package com.dika.quranapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class ChaptersResponse(
    @SerializedName("chapters")
    val chapters: List<ChapterResponse> = emptyList()
)