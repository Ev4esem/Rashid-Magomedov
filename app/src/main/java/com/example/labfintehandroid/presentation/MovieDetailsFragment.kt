package com.example.labfintehandroid.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.labfintehandroid.Utils.Resource
import com.example.labfintehandroid.databinding.FragmentMovieDetailsBinding
import com.example.labfintehandroid.domain.model.MovieDetails
import com.example.labfintehandroid.domain.model.MovieItem
import com.example.labfintehandroid.domain.retrofit.Constant.MOVIE_ID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment : Fragment() {

    val args : MovieDetailsFragmentArgs by navArgs()
    private val viewModel by viewModels<MovieDetailsViewModel>()
    private lateinit var binding : FragmentMovieDetailsBinding

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater : LayoutInflater, container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View {
        binding = FragmentMovieDetailsBinding.inflate(layoutInflater)
        val movieId = args.movieId
        viewModel.getMovieById(movieId)

        viewModel.movieDetails.observe(viewLifecycleOwner) { resourse ->
               resourse?.let { movieDataDetails(it) }
        }
        binding.imBack.setOnClickListener {
            findNavController().popBackStack()
        }

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