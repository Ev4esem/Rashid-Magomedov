package com.example.labfintehandroid.domain.mapper

import com.example.labfintehandroid.domain.model.Genre

data class GenreDto(
    val genre : String
)

fun GenreDto.toGenre() : Genre = Genre(
    genre = genre
)


