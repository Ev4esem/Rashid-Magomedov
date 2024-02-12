package com.example.labfintehandroid.presentation

import android.util.Log
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

    private val _movieDetails = MutableLiveData<MovieDetails>()
    val movieDetails : LiveData<MovieDetails> = _movieDetails


    fun getMovieById(
        movieId : Int
    ) {
        viewModelScope.launch {
            try {

                val movieItem = getMovieByIdUseCase(movieId)
                _movieDetails.postValue(movieItem)
            } catch (e : Exception) {
                Log.e("DetailsError", e.message.toString())
            }
        }
    }

}