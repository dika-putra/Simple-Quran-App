package com.dika.quranapp.data.mapper

import com.dika.quranapp.data.local.model.VerseWithWords
import com.dika.quranapp.domain.model.Verse

fun VerseWithWords.toModel() = Verse(
    id = verse.id,
    verseNumber = verse.verseNumber,
    verseKey = verse.verseKey,
    words = words.map { it.toModel() }
)