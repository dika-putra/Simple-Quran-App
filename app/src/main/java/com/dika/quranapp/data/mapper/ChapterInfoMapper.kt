package com.dika.quranapp.data.mapper

import com.dika.quranapp.data.local.model.ChapterInfoEntity
import com.dika.quranapp.data.remote.model.ChapterInfoResponse
import com.dika.quranapp.domain.model.ChapterInfo

fun ChapterInfoResponse.ChapterInfo.toEntity() = ChapterInfoEntity(
    id = id,
    chapterId = chapterId,
    languageName = languageName,
    shortText = shortText,
    source = source,
    text = text
)

fun ChapterInfoEntity.toModel() = ChapterInfo(
    id = id,
    chapterId = chapterId,
    languageName = languageName,
    shortText = shortText,
    source = source,
    text = text
)