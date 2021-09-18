package com.dika.quranapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class PaginationResponse(
    @SerializedName("per_page")
    val perPage: Int = 0,
    @SerializedName("current_page")
    val currentPage: Int = 0,
    @SerializedName("next_page")
    val nextPage: Int = 0,
    @SerializedName("total_pages")
    val totalPages: Int = 0,
    @SerializedName("total_records")
    val totalRecords: Int = 0
)