package com.dika.quranapp.domain.usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.dika.quranapp.domain.model.Verse
import com.dika.quranapp.domain.repository.VerseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetVersesImpl @Inject constructor(
    private val repository: VerseRepository
) : GetVerses {
    @ExperimentalPagingApi
    override fun invoke(number: Int): Flow<PagingData<Verse>> = repository.getVerses(number)
}