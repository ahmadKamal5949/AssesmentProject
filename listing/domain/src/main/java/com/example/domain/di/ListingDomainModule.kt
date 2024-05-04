package com.example.domain.di

import com.example.domain.repository.UniversitiesRepo
import com.example.domain.use_case.GetUniversitiesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object ListingDomainModule {

    @Provides
    fun provideGetUniversitiesUseCase(universitiesRepo: UniversitiesRepo) : GetUniversitiesUseCase{
        return GetUniversitiesUseCase(universitiesRepo)
    }
}