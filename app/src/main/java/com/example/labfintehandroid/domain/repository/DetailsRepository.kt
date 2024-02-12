package com.example.labfintehandroid.domain.repository

import com.example.labfintehandroid.domain.model.MovieDetails
import com.example.labfintehandroid.domain.model.MovieItem

interface DetailsRepository {

    suspend fun getMovieById(id : Int) : MovieDetails

}