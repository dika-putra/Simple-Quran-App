package com.dika.quranapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dika.quranapp.data.local.dao.*
import com.dika.quranapp.data.local.model.*

@Database(
    entities = [
        ChapterEntity::class,
        VerseEntity::class,
        WordEntity::class,
        VerseWordCrossRef::class,
        ChapterInfoEntity::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun chapterDao(): ChapterDao
    abstract fun verseDao(): VerseDao
    abstract fun wordDao(): WordDao
    abstract fun verseWordDao(): VerseWordDao
    abstract fun chapterInfoDao(): ChapterInfoDao

    companion object {
        const val DATABASE_NAME = "quran_db"
    }
}