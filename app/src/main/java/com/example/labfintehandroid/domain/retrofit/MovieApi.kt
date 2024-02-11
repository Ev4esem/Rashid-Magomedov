package com.example.labfintehandroid.domain.retrofit

import com.example.labfintehandroid.domain.mapper.MovieListDto
import com.example.labfintehandroid.domain.retrofit.Constant.TOP_100_POPULAR_FILMS
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("/api/v2.2/films/top")
    suspend fun getTopMovies(
        @Query("type") type: String
    ) : MovieListDto
}