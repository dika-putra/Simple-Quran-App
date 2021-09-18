package com.dika.quranapp.domain.usecase

import androidx.lifecycle.LiveData
import com.dika.quranapp.data.common.Result
import com.dika.quranapp.domain.model.ChapterInfo
import com.dika.quranapp.domain.repository.ChapterRepository
import javax.inject.Inject

class GetChapterInfoImpl @Inject constructor(
    private val repository: ChapterRepository
) : GetChapterInfo {
    override fun invoke(chapterId: Int): LiveData<Result<ChapterInfo?>> =
        repository.getChapterInfo(chapterId)
}