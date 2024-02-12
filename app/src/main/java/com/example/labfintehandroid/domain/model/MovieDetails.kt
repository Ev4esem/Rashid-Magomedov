package com.example.labfintehandroid.domain.model

data class MovieDetails(
    val id: String,
    val name: String,
    val description: String,
    val poster: String,
    val genres: List<Genre>,
    val countries: List<Countries>,
)
