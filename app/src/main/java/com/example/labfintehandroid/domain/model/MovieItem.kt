package com.example.labfintehandroid.domain.model

data class MovieItem(
    val id : Int,
    val title : String,
    val imagePreviewUrl : String,
    val data : String,
    val genre : List<Genre>,
    val countries : List<Countries>
)


