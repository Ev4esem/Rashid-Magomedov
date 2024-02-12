package com.example.labfintehandroid.domain.repository

import com.example.labfintehandroid.domain.model.MovieItem
import com.example.labfintehandroid.domain.model.MovieList
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getMovieList() : MovieList

//    fun setFavorite(
//        film: MovieItem,
//    ): Flow<Boolean>

}