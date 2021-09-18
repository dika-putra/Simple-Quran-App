package com.dika.quranapp.domain.usecase

import androidx.lifecycle.LiveData
import com.dika.quranapp.data.common.Result
import com.dika.quranapp.domain.model.ChapterInfo

interface GetChapterInfo {
    fun invoke(chapterId: Int): LiveData<Result<ChapterInfo?>>
}