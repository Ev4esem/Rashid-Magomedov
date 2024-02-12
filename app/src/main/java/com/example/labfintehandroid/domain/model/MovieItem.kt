package com.example.labfintehandroid.domain.model

data class MovieItem(
    val id : Int,
    val title : String,
    val imagePreviewUrl : String,
    val data : String,
    val genre : List<Genre>,
    val imagePosterUrl : String,
    val countries : List<Countries>,
    val description : String
)


