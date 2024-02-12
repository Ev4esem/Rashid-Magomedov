package com.example.labfintehandroid.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.labfintehandroid.Utils.Resource
import com.example.labfintehandroid.databinding.FragmentMovieDetailsBinding
import com.example.labfintehandroid.domain.model.MovieDetails
import com.example.labfintehandroid.domain.retrofit.Constant.MOVIE_ID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment : Fragment() {

    private var movieId : String? = null
    private val viewModel by viewModels<MovieDetailsViewModel>()
    private lateinit var binding : FragmentMovieDetailsBinding

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movieId = it.getString(MOVIE_ID)
        }
    }

    override fun onCreateView(
        inflater : LayoutInflater, container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View {
        binding = FragmentMovieDetailsBinding.inflate(layoutInflater)

        viewModel.movieDetails.observe(viewLifecycleOwner) { resourse ->
        when(resourse) {
            is Resource.Loading -> {

            }
            is Resource.Success -> {
                val movieDetails = resourse.data

                movieDetails?.let { movieDataDetails(it) }
            }
            is Resource.Error -> {

            }

        }
        }
        binding.imBack.setOnClickListener {
            findNavController().popBackStack()
        }
        movieId?.let { viewModel.getMovieById(it) }
        return binding.root
    }

    private fun movieDataDetails(movieItem : MovieDetails) {
        binding.imMovieDetails.setImageResource(movieItem.poster.toInt())
        binding.tvTitle.text = movieItem.name
        binding.tvDescription.text = movieItem.description

        val firstThreeGenres = movieItem.genres.take(4)
        val genreString = firstThreeGenres.joinToString(" ,") { it.genre }
        val firstThreeCountries = movieItem.countries.take(4)
        val countriesString = firstThreeCountries.joinToString(" ,") { it.country }
        binding.tvListGenre.text = genreString
        binding.tvCountries.text = countriesString
    }

}