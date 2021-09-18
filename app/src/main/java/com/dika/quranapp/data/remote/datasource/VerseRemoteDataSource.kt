package com.dika.quranapp.data.remote.datasource

import com.dika.quranapp.data.common.Result
import com.dika.quranapp.data.remote.model.ChaptersResponse
import com.dika.quranapp.data.remote.model.VersesResponse

interface VerseRemoteDataSource {
    suspend fun getVerses(number: Int, page: Int, limit: Int): Result<VersesResponse>
}