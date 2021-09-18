package com.dika.quranapp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.dika.quranapp.data.common.BaseDao
import com.dika.quranapp.data.local.model.VerseEntity
import com.dika.quranapp.data.local.model.VerseWithWords

@Dao
interface VerseDao : BaseDao<VerseEntity> {
    @Query("SELECT * FROM verses")
    fun getAll(): LiveData<List<VerseEntity>>

    @Transaction
    @Query("SELECT * FROM verses")
    fun getVersesWithWords(): List<VerseWithWords>
}