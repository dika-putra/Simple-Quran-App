package com.dika.quranapp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.dika.quranapp.data.common.BaseDao
import com.dika.quranapp.data.local.model.WordEntity

interface WordDao : BaseDao<WordEntity> {
    @Query("SELECT * FROM words")
    fun getAll(): LiveData<List<WordEntity>>
}