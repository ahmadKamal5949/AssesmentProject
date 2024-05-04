package com.example.domain.use_case

import com.example.domain.model.Universities
import com.example.domain.repository.UniversitiesRepo
import com.example.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetUniversitiesUseCase (private val universitiesRepo: UniversitiesRepo){
    operator fun invoke():Flow<Resource<List<Universities>>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = universitiesRepo.getUniversitiesDetails()))
        }catch (e: Exception){
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}