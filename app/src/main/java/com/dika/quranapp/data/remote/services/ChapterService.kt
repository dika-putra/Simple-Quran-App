package com.dika.quranapp.data.remote.services

import com.dika.quranapp.data.remote.model.ChaptersResponse
import retrofit2.Response
import retrofit2.http.GET

interface ChapterService {
    @GET("chapters?language=en")
    suspend fun getChapters(): Response<ChaptersResponse>
}