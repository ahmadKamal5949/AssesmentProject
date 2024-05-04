package com.example.listing_data.network

import com.example.listing_data.model.UniversitiesResponse
import com.example.utils.Constant
import retrofit2.http.GET
import retrofit2.http.Query

interface UniversitiesApiService {

    @GET("search")
    suspend fun getUniversities(
        @Query("country") country:String
    ): UniversitiesResponse
}