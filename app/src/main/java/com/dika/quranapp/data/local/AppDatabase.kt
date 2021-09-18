package com.dika.quranapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dika.quranapp.data.local.dao.ChapterDao
import com.dika.quranapp.data.local.dao.VerseDao
import com.dika.quranapp.data.local.dao.VerseWordDao
import com.dika.quranapp.data.local.dao.WordDao
import com.dika.quranapp.data.local.model.ChapterEntity
import com.dika.quranapp.data.local.model.VerseEntity
import com.dika.quranapp.data.local.model.VerseWithWords
import com.dika.quranapp.data.local.model.WordEntity

@Database(
    entities = [
        ChapterEntity::class,
        VerseEntity::class,
        WordEntity::class,
        VerseWithWords::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun chapterDao(): ChapterDao
    abstract fun verseDao(): VerseDao
    abstract fun wordDao(): WordDao
    abstract fun verseWordDao(): VerseWordDao

    companion object {
        const val DATABASE_NAME = "quran_db"
    }
}