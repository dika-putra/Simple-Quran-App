package com.dika.quranapp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.dika.quranapp.data.common.BaseDao
import com.dika.quranapp.data.local.model.ChapterEntity
import com.dika.quranapp.data.local.model.ChapterInfoEntity

@Dao
interface ChapterInfoDao : BaseDao<ChapterInfoEntity> {
    @Query("SELECT * FROM chapter_info WHERE id = :chapterId")
    fun getById(chapterId: Int): LiveData<ChapterInfoEntity>
}