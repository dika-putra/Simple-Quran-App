package com.dika.quranapp.domain.model

data class ChapterInfo(
    val id: Int = 0,
    val chapterId: Int = 0,
    val languageName: String = "",
    val shortText: String = "",
    val source: String = "",
    val text: String = ""
)