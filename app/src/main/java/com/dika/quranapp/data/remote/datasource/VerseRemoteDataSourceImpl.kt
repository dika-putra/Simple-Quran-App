package com.dika.quranapp.data.remote.datasource

import com.dika.quranapp.data.common.BaseDataSource
import com.dika.quranapp.data.common.Result
import com.dika.quranapp.data.remote.model.VersesResponse
import com.dika.quranapp.data.remote.services.VerseService
import javax.inject.Inject

class VerseRemoteDataSourceImpl @Inject constructor(
    private val verseService: VerseService
) : BaseDataSource(), VerseRemoteDataSource {
    override suspend fun getVerses(number: Int, page: Int, limit: Int): Result<VersesResponse> =
        getResult { verseService.getVersesByChapter(number, page, limit) }
}