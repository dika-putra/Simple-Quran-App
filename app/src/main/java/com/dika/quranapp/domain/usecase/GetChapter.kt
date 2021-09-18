package com.dika.quranapp.domain.usecase

import androidx.lifecycle.LiveData
import com.dika.quranapp.data.common.Result
import com.dika.quranapp.domain.model.Chapter

interface GetChapter {
    fun invoke(): LiveData<Result<List<Chapter>>>
}