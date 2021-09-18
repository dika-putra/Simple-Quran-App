package com.dika.quranapp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chapter_info")
data class ChapterInfoEntity(
    @PrimaryKey
    val id: Int = 0,
    val chapterId: Int = 0,
    val languageName: String = "",
    val shortText: String = "",
    val source: String = "",
    val text: String = ""
)