package com.example.listing_data.repository

import com.example.domain.model.Universities
import com.example.domain.repository.UniversitiesRepo
import com.example.listing_data.mapper.toDomainUniversities
import com.example.listing_data.network.UniversitiesApiService
import com.example.listing_data.room.ListingDAO
import com.example.utils.Constant

class UniversitiesImp(private val apiService: UniversitiesApiService,
                      private val listingDAO: ListingDAO) : UniversitiesRepo {
    override suspend fun getUniversitiesDetails(): List<Universities> {
        return try {
            val temp  = apiService.getUniversities(Constant.COUNTRY)
                .map {
                    it.toDomainUniversities()}
            listingDAO.insertList(temp)
            listingDAO.getNewsArticle()

        }catch (e : Exception){
            listingDAO.getNewsArticle()
        }
    }
}
