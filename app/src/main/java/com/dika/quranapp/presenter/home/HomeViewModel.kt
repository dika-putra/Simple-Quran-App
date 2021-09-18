package com.dika.quranapp.presenter.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.dika.quranapp.domain.usecase.GetChapters
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getChapters: GetChapters
) : ViewModel() {
    private val _chaptersLiveData = MutableLiveData<Unit>()
    val chaptersLiveData = _chaptersLiveData.switchMap {
        getChapters.invoke()
    }

    init {
        onRefresh()
    }

    fun onRefresh() {
        _chaptersLiveData.value = Unit
    }
}