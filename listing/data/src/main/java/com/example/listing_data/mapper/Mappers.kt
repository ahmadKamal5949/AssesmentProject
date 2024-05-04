package com.example.listing_data.mapper

import com.example.domain.model.Universities
import com.example.listing_data.model.UniversitiesResponseItemDTO

fun UniversitiesResponseItemDTO.toDomainUniversities():Universities{
    return Universities(
        name = this.name!!,
        state = this.state.orEmpty(),
        domains = this.domains!!,
        web_pages =  this.web_pages!!,
        alpha_two_code = this.alpha_two_code!!,
        country = this.country!!
    )
}