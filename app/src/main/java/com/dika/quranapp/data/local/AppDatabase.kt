package com.dika.quranapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dika.quranapp.data.local.dao.ChapterDao
import com.dika.quranapp.data.local.model.ChapterEntity

@Database(
    entities = [ChapterEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun chapterDao(): ChapterDao

    companion object {
        const val DATABASE_NAME = "quran_db"
    }
}