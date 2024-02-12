package com.example.labfintehandroid.domain.repository

import android.util.Log
import com.example.labfintehandroid.Utils.FilmQueryType
import com.example.labfintehandroid.domain.mapper.toMovieListItem
import com.example.labfintehandroid.domain.model.MovieList
import com.example.labfintehandroid.domain.retrofit.MovieApi
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieApi : MovieApi,
) : MovieRepository {

    companion object {
        const val TAG = "MovieRepositoryImpl"
    }

    override suspend fun getMovieList() : MovieList {
        val movies = movieApi.getTopMovies(FilmQueryType.TOP_100.type)
        Log.d(TAG, "getMovieList: $movies")

        return movies.toMovieListItem()
    }




}