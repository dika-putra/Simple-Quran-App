package com.dika.quranapp.data.remote.datasource

import com.dika.quranapp.data.common.Result
import com.dika.quranapp.data.remote.model.ChapterInfoResponse
import com.dika.quranapp.data.remote.model.ChaptersResponse

interface ChapterRemoteDataSource {
    suspend fun getChapters(): Result<ChaptersResponse>
    suspend fun getChapterInfo(chapterId: Int): Result<ChapterInfoResponse>
}