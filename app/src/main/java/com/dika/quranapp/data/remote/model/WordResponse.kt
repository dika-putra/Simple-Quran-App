package com.dika.quranapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class WordResponse(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("position")
    val position: Int = 0,
    @SerializedName("text")
    val text: String = "",
    @SerializedName("translation")
    val translation: TranslationResponse = TranslationResponse(),
)