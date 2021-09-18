package com.dika.quranapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class ChapterResponse(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("revelation_place")
    val revelationPlace: String = "",
    @SerializedName("revelation_order")
    val revelationOrder: Int = 0,
    @SerializedName("name_simple")
    val nameSimple: String = "",
    @SerializedName("name_arabic")
    val nameArabic: String = "",
    @SerializedName("verses_count")
    val versesCount: Int = 0
)