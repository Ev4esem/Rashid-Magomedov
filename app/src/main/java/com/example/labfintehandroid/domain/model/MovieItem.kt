package com.example.labfintehandroid.domain.model

data class MovieItem(
    val id : Int,
    val title : String,
    val imageUrl : String,
    val imagePreviewUrl : String,
    val data : Int,
    val genre : List<Genre>,
    val description : String
)


