package com.dika.quranapp.presenter.verse

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.cachedIn
import com.dika.quranapp.domain.usecase.GetVerses
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VerseViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getVerses: GetVerses
) : ViewModel() {
    private val chapterId: Int = savedStateHandle["chapterId"] ?: 0

    @ExperimentalPagingApi
    val versesResult = getVerses
        .invoke(chapterId)
        .cachedIn(viewModelScope)
}