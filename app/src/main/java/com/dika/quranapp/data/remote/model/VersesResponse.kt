package com.dika.quranapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class VersesResponse(
    @SerializedName("verses")
    val verses: List<VerseResponse> = listOf(),
    @SerializedName("pagination")
    val pagination: PaginationResponse = PaginationResponse()
)