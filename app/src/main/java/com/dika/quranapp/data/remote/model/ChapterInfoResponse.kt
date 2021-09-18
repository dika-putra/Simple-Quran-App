package com.dika.quranapp.data.remote.model

import com.google.gson.annotations.SerializedName


data class ChapterInfoResponse(
    @SerializedName("chapter_info")
    val chapterInfo: ChapterInfo = ChapterInfo()
) {
    data class ChapterInfo(
        @SerializedName("id")
        val id: Int = 0,
        @SerializedName("chapter_id")
        val chapterId: Int = 0,
        @SerializedName("language_name")
        val languageName: String = "",
        @SerializedName("short_text")
        val shortText: String = "",
        @SerializedName("source")
        val source: String = "",
        @SerializedName("text")
        val text: String = ""
    )
}