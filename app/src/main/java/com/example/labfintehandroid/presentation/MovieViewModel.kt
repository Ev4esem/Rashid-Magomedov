package com.example.labfintehandroid.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.labfintehandroid.Utils.Resource
import com.example.labfintehandroid.domain.model.MovieItem
import com.example.labfintehandroid.domain.model.MovieList
import com.example.labfintehandroid.domain.use_case.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMovieListUseCase : GetMovieListUseCase
) : ViewModel() {



    private val _itemMovie = MutableLiveData<Resource<MovieList>>(Resource.Loading())
    val itemMovie : LiveData<Resource<MovieList>> = _itemMovie

    init {
        getItemMovie()
    }

    fun getItemMovie() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val movieItem = getMovieListUseCase()
                 _itemMovie.postValue(Resource.Success(movieItem))
            } catch (e : Exception) {
                _itemMovie.postValue(Resource.Error(e.message ?: "An error occurred"))
                Log.e("NetworkError", e.message.toString())
            }

        }
    }

}