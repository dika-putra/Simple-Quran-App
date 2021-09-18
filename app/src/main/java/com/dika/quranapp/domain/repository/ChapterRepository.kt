package com.dika.quranapp.domain.repository

import androidx.lifecycle.LiveData
import com.dika.quranapp.data.common.Result
import com.dika.quranapp.domain.model.Chapter
import com.dika.quranapp.domain.model.ChapterInfo

interface ChapterRepository {
    fun getChapter(): LiveData<Result<List<Chapter>>>
    fun getChapterInfo(chapterId: Int): LiveData<Result<ChapterInfo?>>
}