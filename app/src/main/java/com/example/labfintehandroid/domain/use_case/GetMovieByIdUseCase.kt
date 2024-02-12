package com.example.labfintehandroid.domain.use_case

import com.example.labfintehandroid.domain.model.MovieDetails
import com.example.labfintehandroid.domain.model.MovieItem
import com.example.labfintehandroid.domain.repository.DetailsRepository
import javax.inject.Inject

class GetMovieByIdUseCase @Inject constructor(private val detailsRepository : DetailsRepository ) {

    suspend operator fun invoke(movieId : Int) : MovieDetails {
        return detailsRepository.getMovieById(movieId)
    }

}