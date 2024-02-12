package com.example.labfintehandroid.domain.mapper

import com.example.labfintehandroid.domain.model.Countries
import com.example.labfintehandroid.domain.model.Genre
import com.example.labfintehandroid.domain.model.MovieItem
import com.google.gson.annotations.SerializedName


data class MovieItemDto(
    @SerializedName("kinopoiskId")
    val id : Int,
    @SerializedName("nameRu")
    val title : String,
    @SerializedName("posterUrlPreview")
    val imagePreviewUrl : String,
    @SerializedName("year")
    val data : String,
    @SerializedName("genres")
    val genre : List<GenreDto>,
    @SerializedName("countries")
    val country : List<CountryDto>

)

fun MovieItemDto.toMovieItem() : MovieItem = MovieItem(
    id = id,
    title = title,
    data = data,
    genre = genre.toGenreList(),
    imagePreviewUrl = imagePreviewUrl ,
    countries = country.toCountriesList()
)

fun List<GenreDto>.toGenreList() : List<Genre> {
    return map { it.toGenre() }
}

fun List<CountryDto>.toCountriesList() : List<Countries> {
    return map { it.toCountry() }
}
