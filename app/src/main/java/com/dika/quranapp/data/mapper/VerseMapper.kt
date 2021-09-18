package com.dika.quranapp.data.mapper

import com.dika.quranapp.data.local.model.VerseEntity
import com.dika.quranapp.data.remote.model.VerseResponse
import com.dika.quranapp.domain.model.Verse

fun VerseResponse.toEntity() = VerseEntity(
    id = id,
    verseNumber = verseNumber,
    verseKey = verseKey
)

fun VerseEntity.toModel() = Verse(
    id = id,
    verseNumber = verseNumber,
    verseKey = verseKey
)