package com.example.labfintehandroid.domain.mapper

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
    @SerializedName("posterUrl")
    val imageUrl : String,
    @SerializedName("year")
    val data : Int,
    @SerializedName("genres")
    val genre : List<GenreDto>,
)

fun MovieItemDto.toMovieItem() : MovieItem = MovieItem(
    id = id,
    title = title,
    imageUrl = imageUrl,
    data = data,
    genre = genre.toGenreList(),
    imagePreviewUrl = imagePreviewUrl ,
    description = "description" // В списках описание не приходит только в детальных )
)

fun List<GenreDto>.toGenreList() : List<Genre> {
    return map { it.toGenre() }
}
