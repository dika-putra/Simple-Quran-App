package com.dika.quranapp.data.remote.datasource

import com.dika.quranapp.data.common.BaseDataSource
import com.dika.quranapp.data.common.Result
import com.dika.quranapp.data.remote.model.ChaptersResponse
import com.dika.quranapp.data.remote.services.ChapterService
import javax.inject.Inject

class ChapterRemoteDataSourceImpl @Inject constructor(
    private val chapterService: ChapterService
) : BaseDataSource(), ChapterRemoteDataSource {
    override suspend fun getChapters(): Result<ChaptersResponse> =
        getResult { chapterService.getChapters() }
}