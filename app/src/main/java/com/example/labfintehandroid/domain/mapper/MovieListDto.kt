package com.example.labfintehandroid.domain.mapper

import com.example.labfintehandroid.domain.model.MovieList
import com.google.gson.annotations.SerializedName

data class MovieListDto(
    @SerializedName("films")
    val movieList : List<MovieItemDto>
)

fun MovieListDto.toMovieListItem() : MovieList = MovieList(
    movieList.map { it.toMovieItem() }
)


