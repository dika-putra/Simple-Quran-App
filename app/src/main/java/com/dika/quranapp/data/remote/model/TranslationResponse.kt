package com.dika.quranapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class TranslationResponse(
    @SerializedName("text")
    val text: String = "",
)