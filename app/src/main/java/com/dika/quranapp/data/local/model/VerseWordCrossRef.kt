package com.dika.quranapp.data.local.model

import androidx.room.Entity

@Entity(tableName = "verse_join_word_ref", primaryKeys = ["verseId", "wordId"])
data class VerseWordCrossRef(
    val verseId: Int,
    val wordId: Int
)