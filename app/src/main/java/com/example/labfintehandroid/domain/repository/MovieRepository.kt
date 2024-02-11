package com.example.labfintehandroid.domain.repository

import com.example.labfintehandroid.domain.model.MovieItem
import com.example.labfintehandroid.domain.model.MovieList

interface MovieRepository {

    suspend fun getMovieList() : MovieList

}