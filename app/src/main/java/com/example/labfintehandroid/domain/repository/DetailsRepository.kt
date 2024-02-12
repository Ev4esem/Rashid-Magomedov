package com.example.labfintehandroid.domain.repository

import com.example.labfintehandroid.domain.model.MovieDetails

interface DetailsRepository {

    suspend fun getMovieById(id : String,force : Boolean) : MovieDetails

}