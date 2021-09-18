package com.dika.quranapp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.dika.quranapp.data.common.BaseDao
import com.dika.quranapp.data.local.model.VerseWordCrossRef

interface VerseWordDao : BaseDao<VerseWordCrossRef> {
    @Query("SELECT * FROM verse_join_word_ref")
    fun getAll(): LiveData<List<VerseWordCrossRef>>
}