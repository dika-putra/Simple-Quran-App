package com.dika.quranapp.data.remote.services

import com.dika.quranapp.data.remote.model.VersesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface VerseService {
    @GET("verses/by_chapter/{number}?language=en&words=true")
    suspend fun getVersesByChapter(
        @Path("number") number: Int,
        @Query("page") page: Int,
        @Query("per_page") limit: Int,
    ): Response<VersesResponse>
}