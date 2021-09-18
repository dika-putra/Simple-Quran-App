package com.dika.quranapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.dika.quranapp.data.common.Result
import com.dika.quranapp.data.common.resultLiveData
import com.dika.quranapp.data.local.dao.ChapterDao
import com.dika.quranapp.data.local.dao.ChapterInfoDao
import com.dika.quranapp.data.mapper.toEntity
import com.dika.quranapp.data.mapper.toModel
import com.dika.quranapp.data.remote.datasource.ChapterRemoteDataSource
import com.dika.quranapp.domain.model.Chapter
import com.dika.quranapp.domain.model.ChapterInfo
import com.dika.quranapp.domain.repository.ChapterRepository
import javax.inject.Inject

class ChapterRepositoryImpl @Inject constructor(
    private val chapterLocalDataSource: ChapterDao,
    private val chapterInfoLocalDataSource: ChapterInfoDao,
    private val remoteDataSource: ChapterRemoteDataSource
) : ChapterRepository {
    override fun getChapter(): LiveData<Result<List<Chapter>>> = resultLiveData(
        databaseQuery = {
            Transformations.map(chapterLocalDataSource.getAll()) { it ->
                it.map { it.toModel() }
            }
        },
        networkCall = { remoteDataSource.getChapters() },
        saveCallResult = { it ->
            val entities = it.chapters.map { it.toEntity() }
            chapterLocalDataSource.insert(entities)
        }
    )

    override fun getChapterInfo(chapterId: Int): LiveData<Result<ChapterInfo?>> = resultLiveData(
        databaseQuery = {
            Transformations.map(chapterInfoLocalDataSource.getById(chapterId)) {
                it?.toModel()
            }
        },
        networkCall = { remoteDataSource.getChapterInfo(chapterId) },
        saveCallResult = { chapterInfoLocalDataSource.insert(it.chapterInfo.toEntity()) }
    )
}