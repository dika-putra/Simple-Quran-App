package com.dika.quranapp.data.repository

import androidx.lifecycle.LiveData
import com.dika.quranapp.data.common.Result
import com.dika.quranapp.data.common.resultLiveData
import com.dika.quranapp.data.local.dao.ChapterDao
import com.dika.quranapp.data.local.model.ChapterEntity
import com.dika.quranapp.data.mapper.toEntity
import com.dika.quranapp.data.remote.datasource.ChapterRemoteDataSource
import com.dika.quranapp.domain.repository.ChapterRepository
import javax.inject.Inject

class ChapterRepositoryImpl @Inject constructor(
    private val localDataSource: ChapterDao,
    private val remoteDataSource: ChapterRemoteDataSource
) : ChapterRepository {
    override fun getChapter(): LiveData<Result<List<ChapterEntity>>> = resultLiveData(
        databaseQuery = { localDataSource.getAll() },
        networkCall = { remoteDataSource.getChapters() },
        saveCallResult = { it ->
            val entities = it.chapters.map { it.toEntity() }
            localDataSource.insert(entities)
        }
    )
}