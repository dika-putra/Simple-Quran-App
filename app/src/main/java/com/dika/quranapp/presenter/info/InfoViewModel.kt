package com.dika.quranapp.presenter.info

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.dika.quranapp.domain.usecase.GetChapterInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getChapterInfo: GetChapterInfo
) : ViewModel() {
    private val chapterId: Int = savedStateHandle["chapterId"] ?: 0

    private val _chapterInfoLiveData = MutableLiveData<Int>()
    val chapterInfoLiveData = _chapterInfoLiveData.switchMap {
        getChapterInfo.invoke(it)
    }

    init {
        onRefresh()
    }

    fun onRefresh() {
        _chapterInfoLiveData.value = chapterId
    }
}