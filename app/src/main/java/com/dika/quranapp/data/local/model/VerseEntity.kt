package com.dika.quranapp.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "verses")
data class VerseEntity(
    @PrimaryKey
    @ColumnInfo(name = "verseId")
    val id: Int = 0,
    val verseNumber: Int = 0,
    val verseKey: String = ""
)