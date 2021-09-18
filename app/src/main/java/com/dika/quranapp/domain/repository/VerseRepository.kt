package com.dika.quranapp.domain.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.dika.quranapp.domain.model.Verse
import kotlinx.coroutines.flow.Flow

interface VerseRepository {
    @ExperimentalPagingApi
    fun getVerses(number: Int): Flow<PagingData<Verse>>
}