package com.dika.quranapp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chapter")
data class ChapterEntity(
    @PrimaryKey
    val id: Int = 0,
    val revelationPlace: String = "",
    val revelationOrder: Int = 0,
    val nameSimple: String = "",
    val nameArabic: String = "",
    val versesCount: Int = 0
)