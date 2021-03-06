package com.dika.quranapp.domain.usecase

import androidx.lifecycle.LiveData
import com.dika.quranapp.data.common.Result
import com.dika.quranapp.domain.model.Chapter
import com.dika.quranapp.domain.repository.ChapterRepository
import javax.inject.Inject

class GetChaptersImpl @Inject constructor(
    private val repository: ChapterRepository
) : GetChapters {
    override fun invoke(): LiveData<Result<List<Chapter>>> = repository.getChapter()
}