package com.example.presentation

import com.example.domain.model.Universities

data class ListingState(
    val isLoading : Boolean = false,
    val error : String = "",
    val data : List<Universities> ?= null

)
