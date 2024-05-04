package com.example.listing_data.di

import com.example.domain.repository.UniversitiesRepo
import com.example.listing_data.network.UniversitiesApiService
import com.example.listing_data.repository.UniversitiesImp
import com.example.listing_data.room.ListingDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object ListingDataModule {

    @Provides
    fun universitiesApiService(retrofit: Retrofit) : UniversitiesApiService{
        return retrofit.create(UniversitiesApiService::class.java)
    }

    @Provides
    fun provideListingRepo(apiService: UniversitiesApiService, listingDAO: ListingDAO) : UniversitiesRepo{
        return UniversitiesImp(apiService, listingDAO)
    }
}