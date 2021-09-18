package com.dika.quranapp.domain.usecase

import androidx.lifecycle.LiveData
import com.dika.quranapp.data.common.Result
import com.dika.quranapp.domain.model.Chapter
import com.dika.quranapp.domain.repository.ChapterRepository
import javax.inject.Inject

class GetChapterImpl @Inject constructor(
    private val repository: ChapterRepository
) : GetChapter {
    override fun invoke(): LiveData<Result<List<Chapter>>> = repository.getChapter()
}