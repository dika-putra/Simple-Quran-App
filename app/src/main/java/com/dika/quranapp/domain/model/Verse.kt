package com.dika.quranapp.domain.model

data class Verse(
    val id: Int = 0,
    val verseNumber: Int = 0,
    val verseKey: String = "",
    val words: List<Word> = emptyList()
)