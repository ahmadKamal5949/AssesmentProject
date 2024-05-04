package com.example.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_case.GetUniversitiesUseCase
import com.example.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ListingViewModel @Inject constructor(private val universitiesUseCase : GetUniversitiesUseCase)
    : ViewModel() {

    private val _listUniversities = MutableStateFlow(ListingState())
    val listUniversities : StateFlow<ListingState> = _listUniversities

    init {

        getUniversitiesData()
    }

    private fun getUniversitiesData() {
        universitiesUseCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    _listUniversities.value = ListingState(isLoading = true)
                }
                is Resource.Error -> {
                    _listUniversities.value = ListingState(error = it.message)
                }
                is Resource.Success -> {
                    _listUniversities.value = ListingState(data = it.data)
                }
            }


        }.launchIn(viewModelScope)
    }


}