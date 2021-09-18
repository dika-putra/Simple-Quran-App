package com.dika.quranapp.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class WordEntity(
    @PrimaryKey
    @ColumnInfo(name = "wordId")
    val id: Int = 0,
    val position: Int = 0,
    val text: String = "",
    @Embedded(prefix = "trans")
    val translation: TranslationEntity = TranslationEntity()
)