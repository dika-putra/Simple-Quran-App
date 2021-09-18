package com.dika.quranapp.data.remote.model
import com.google.gson.annotations.SerializedName

data class VerseResponse(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("verse_number")
    val verseNumber: Int = 0,
    @SerializedName("verse_key")
    val verseKey: String = "",
    @SerializedName("words")
    val wordResponses: List<WordResponse> = listOf()
)