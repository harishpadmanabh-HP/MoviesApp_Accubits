package com.hp.moviesapp_accubits.data.model


import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)