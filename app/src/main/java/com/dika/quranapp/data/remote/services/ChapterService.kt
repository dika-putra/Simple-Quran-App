package com.dika.quranapp.data.remote.services

import com.dika.quranapp.data.remote.model.ChapterInfoResponse
import com.dika.quranapp.data.remote.model.ChaptersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ChapterService {
    @GET("chapters?language=en")
    suspend fun getChapters(): Response<ChaptersResponse>

    @GET("chapters/{id}/info?language=en")
    suspend fun getChapterInfo(
        @Path("id") chapterId: Int
    ): Response<ChapterInfoResponse>
}