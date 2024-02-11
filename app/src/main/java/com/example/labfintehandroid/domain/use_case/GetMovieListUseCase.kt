package com.example.labfintehandroid.domain.use_case

import com.example.labfintehandroid.domain.model.MovieList
import com.example.labfintehandroid.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(private val movieRepository : MovieRepository) {

    suspend operator fun invoke() : MovieList {
        return movieRepository.getMovieList()
    }

}