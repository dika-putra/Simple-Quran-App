package com.dika.quranapp.data.repository

import androidx.paging.*
import com.dika.quranapp.data.local.AppDatabase
import com.dika.quranapp.data.mapper.toModel
import com.dika.quranapp.data.paging.VerseRemoteMediator
import com.dika.quranapp.data.remote.datasource.VerseRemoteDataSource
import com.dika.quranapp.domain.model.Verse
import com.dika.quranapp.domain.repository.VerseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class VerseRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
    private val remoteDataSource: VerseRemoteDataSource
) : VerseRepository {

    @ExperimentalPagingApi
    override fun getVerses(number: Int): Flow<PagingData<Verse>> = Pager(
        config = PagingConfig(pageSize = 20),
        remoteMediator = VerseRemoteMediator(number, database, remoteDataSource)
    ) {
        database.verseDao().getVersesWithWords()
    }.flow.distinctUntilChanged().map { pagingData ->
        pagingData.map { it.toModel() }
    }
}