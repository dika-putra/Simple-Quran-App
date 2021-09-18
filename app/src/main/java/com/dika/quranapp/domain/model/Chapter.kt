package com.dika.quranapp.domain.model

data class Chapter(
    val id: Int = 0,
    val revelationPlace: String = "",
    val revelationOrder: Int = 0,
    val nameSimple: String = "",
    val nameArabic: String = "",
    val versesCount: Int = 0
)