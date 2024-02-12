package com.example.labfintehandroid.domain.retrofit

import com.example.labfintehandroid.domain.mapper.MovieDetailsDto
import com.example.labfintehandroid.domain.mapper.MovieListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("/api/v2.2/films/top")
    suspend fun getTopMovies(
        @Query("type") type: String
    ) : MovieListDto

    @GET("/api/v2.2/films/{id}")
    suspend fun getMovieById(
        @Path("id") id : String
    ) : MovieDetailsDto
}