package com.dika.quranapp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.dika.quranapp.data.common.BaseDao
import com.dika.quranapp.data.local.model.ChapterEntity

@Dao
interface ChapterDao : BaseDao<ChapterEntity> {
    @Query("SELECT * FROM chapter")
    fun getAll(): LiveData<List<ChapterEntity>>
}