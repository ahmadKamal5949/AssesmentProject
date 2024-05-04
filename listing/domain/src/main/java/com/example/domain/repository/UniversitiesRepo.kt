package com.example.domain.repository

import com.example.domain.model.Universities

interface UniversitiesRepo {
    suspend fun getUniversitiesDetails() : List<Universities>
}