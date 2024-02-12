package com.example.labfintehandroid.domain.mapper

import com.example.labfintehandroid.domain.model.Countries

data class CountryDto(
    val country : String
)

fun CountryDto.toCountry() : Countries = Countries(
    country = country
)



