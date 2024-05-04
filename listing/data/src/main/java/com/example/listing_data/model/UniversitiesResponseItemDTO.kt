package com.example.listing_data.model

import com.google.gson.annotations.SerializedName

data class UniversitiesResponseItemDTO(
    val alpha_two_code: String?,
    val country: String?,
    val domains: List<String>?,
    val name: String?,
    @SerializedName("state-province")
    val state: String?="",
    val web_pages: List<String>?
)