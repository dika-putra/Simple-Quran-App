package com.dika.quranapp.data.mapper

import com.dika.quranapp.data.local.model.ChapterEntity
import com.dika.quranapp.data.remote.model.ChapterResponse
import com.dika.quranapp.domain.model.Chapter

fun ChapterResponse.toEntity() = ChapterEntity(
    id = id,
    revelationPlace = revelationPlace,
    revelationOrder = revelationOrder,
    nameSimple = nameSimple,
    nameArabic = nameArabic,
    versesCount = versesCount
)

fun ChapterEntity.toModel() = Chapter(
    id = id,
    revelationPlace = revelationPlace,
    revelationOrder = revelationOrder,
    nameSimple = nameSimple,
    nameArabic = nameArabic,
    versesCount = versesCount
)