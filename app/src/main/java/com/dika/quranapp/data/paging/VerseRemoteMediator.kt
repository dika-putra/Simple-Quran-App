package com.dika.quranapp.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.dika.quranapp.data.common.Result
import com.dika.quranapp.data.local.AppDatabase
import com.dika.quranapp.data.local.model.VerseWithWords
import com.dika.quranapp.data.local.model.VerseWordCrossRef
import com.dika.quranapp.data.mapper.toEntity
import com.dika.quranapp.data.remote.datasource.VerseRemoteDataSource
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

@ExperimentalPagingApi
class VerseRemoteMediator(
    private val number: Int,
    private val database: AppDatabase,
    private val verseRemoteDataSource: VerseRemoteDataSource
) : RemoteMediator<Int, VerseWithWords>() {
    private val verseDao = database.verseDao()
    private val wordDao = database.wordDao()
    private val verseWordDao = database.verseWordDao()
    private var page = 1

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, VerseWithWords>
    ): MediatorResult {
        return try {
            page = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull() ?: return MediatorResult.Success(
                        endOfPaginationReached = true
                    )
                    page + 1
                }
            }

            Timber.d(page.toString())

            val result = verseRemoteDataSource.getVerses(number, page, state.config.pageSize)
            when (result.status) {
                Result.Status.SUCCESS -> {
                    val endPagination = result.data?.verses?.isEmpty() == true
                    result.data?.verses?.let { it ->
                        database.withTransaction {
                            val verses = it.map { it.toEntity() }
                            val words = it.flatMap { it.wordResponses }.map { it.toEntity() }

                            if (loadType == LoadType.REFRESH) {
                                verseDao.delete()
                                wordDao.delete()
                                verseWordDao.delete()
                            }

                            verseDao.insert(verses)
                            wordDao.insert(words)
                            it.forEach { v ->
                                v.wordResponses.forEach { w ->
                                    verseWordDao.insert(VerseWordCrossRef(v.id, w.id))
                                }
                            }
                        }
                    }

                    MediatorResult.Success(
                        endOfPaginationReached = endPagination
                    )
                }
                Result.Status.ERROR -> throw IllegalArgumentException(result.message)
                Result.Status.LOADING -> MediatorResult.Success(false)
            }
        } catch (e: IOException) {
            Timber.e(e)
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            Timber.e(e)
            MediatorResult.Error(e)
        } catch (e: Exception) {
            Timber.e(e)
            MediatorResult.Error(e)
        }
    }
}