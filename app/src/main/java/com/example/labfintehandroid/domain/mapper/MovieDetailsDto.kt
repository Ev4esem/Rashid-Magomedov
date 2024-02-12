package com.example.labfintehandroid.domain.mapper

import com.example.labfintehandroid.domain.model.MovieDetails
import com.google.gson.annotations.SerializedName

data class MovieDetailsDto(
    @SerializedName("kinopoiskId")
    val kinopoiskId: String,
    @SerializedName("countries")
    val countries: List<CountryDto>,
    @SerializedName("description")
    val description: String,
    @SerializedName("genres")
    val genres: List<GenreDto>,
    @SerializedName("nameRu")
    val nameRu: String,
    @SerializedName("posterUrl")
    val posterUrl: String
)


fun MovieDetailsDto.toMovieDetail() = MovieDetails(
    id = kinopoiskId,
    name = nameRu,
    description = description,
    poster = posterUrl,
    genres = genres.map(GenreDto::toGenre),
    countries = countries.map(CountryDto::toCountry)
)
