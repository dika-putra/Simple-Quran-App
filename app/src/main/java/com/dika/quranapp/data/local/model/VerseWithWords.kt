package com.dika.quranapp.data.local.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class VerseWithWords(
    @Embedded
    val verse: VerseEntity,
    @Relation(
        parentColumn = "verseId",
        entityColumn = "wordId",
        associateBy = Junction(VerseWordCrossRef::class)
    )
    val words: List<WordEntity>
)
