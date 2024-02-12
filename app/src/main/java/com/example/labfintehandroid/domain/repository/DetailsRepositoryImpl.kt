package com.example.labfintehandroid.domain.repository

import com.example.labfintehandroid.Utils.FilmQueryType
import com.example.labfintehandroid.domain.mapper.toMovieDetail
import com.example.labfintehandroid.domain.mapper.toMovieListItem
import com.example.labfintehandroid.domain.model.MovieDetails
import com.example.labfintehandroid.domain.model.MovieItem
import com.example.labfintehandroid.domain.retrofit.MovieApi
import javax.inject.Inject

class DetailsRepositoryImpl @Inject constructor(private val movieApi : MovieApi) : DetailsRepository {
    override suspend fun getMovieById(id : Int) : MovieDetails {

        val movieList = movieApi.getMovieById(id.toString()).toMovieDetail()
        return movieList
        }

}