package com.dika.quranapp.domain.repository

import androidx.lifecycle.LiveData
import com.dika.quranapp.data.common.Result
import com.dika.quranapp.data.local.model.ChapterEntity

interface ChapterRepository {
    fun getChapter(): LiveData<Result<List<ChapterEntity>>>
}