package com.example.labfintehandroid.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.labfintehandroid.Utils.Resource
import com.example.labfintehandroid.domain.model.MovieDetails
import com.example.labfintehandroid.domain.model.MovieItem
import com.example.labfintehandroid.domain.use_case.GetMovieByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieByIdUseCase : GetMovieByIdUseCase
) : ViewModel() {

    private val _movieDetails = MutableLiveData<Resource<MovieDetails>>()
    val movieDetails : LiveData<Resource<MovieDetails>> = _movieDetails


    fun getMovieById(
        movieId : String
    ) {
        viewModelScope.launch {
            try {
                _movieDetails.postValue(Resource.Loading())
                val movieItem = getMovieByIdUseCase(movieId)
                _movieDetails.postValue(Resource.Success(movieItem))
            } catch (e : Exception) {
                _movieDetails.postValue((Resource.Error(e.message ?: "An error occurred")))
            }
        }
    }

}