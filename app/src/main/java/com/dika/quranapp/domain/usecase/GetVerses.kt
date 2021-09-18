package com.dika.quranapp.domain.usecase

import androidx.paging.PagingData
import com.dika.quranapp.domain.model.Verse
import kotlinx.coroutines.flow.Flow

interface GetVerses {
    fun invoke(number: Int): Flow<PagingData<Verse>>
}