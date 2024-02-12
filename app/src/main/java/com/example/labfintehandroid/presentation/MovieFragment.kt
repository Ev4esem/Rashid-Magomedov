package com.example.labfintehandroid.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labfintehandroid.R
import com.example.labfintehandroid.Utils.Resource
import com.example.labfintehandroid.databinding.FragmentMovieListBinding
import com.example.labfintehandroid.domain.retrofit.Constant.MOVIE_ID
import com.example.labfintehandroid.presentation.adapter.MyItemMovieRecyclerViewAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment() {

    private lateinit var binding : FragmentMovieListBinding
    private val movieViewModel by viewModels<MovieViewModel>()
    var isPopularityButtonClicked = true
    var isFavoriteButtonClicked = false

    private val movieAdapter : MyItemMovieRecyclerViewAdapter by lazy {
        MyItemMovieRecyclerViewAdapter()
    }
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater : LayoutInflater, container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View {
        binding = FragmentMovieListBinding.inflate(layoutInflater)
        with(binding) {
            rcMovie.adapter = movieAdapter
            rcMovie.layoutManager = LinearLayoutManager(requireContext())

            bFavorite.setOnClickListener {
                isFavoriteButtonClicked = true
                isPopularityButtonClicked = false
                updateButtonColors()
            }

            bPopularity.setOnClickListener {
                isFavoriteButtonClicked = false
                isPopularityButtonClicked = true
                updateButtonColors()
            }
        }



        movieViewModel.itemMovie.observe(viewLifecycleOwner) { resource ->

                when(resource) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.errorLayout.visibility = View.GONE
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.errorLayout.visibility = View.GONE

                    val movieItem = resource.data
                    val movieItemList = movieItem?.movieList
                    movieAdapter.submitList(movieItemList)
                }
                is Resource.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.errorLayout.visibility = View.VISIBLE
                    binding.bRepeat.setOnClickListener {
                        movieViewModel.getItemMovie()
                    }
                }
            }
        }

        movieAdapter.clickItemMovie = { movieItem ->
            val action = MovieFragmentDirections.actionMovieFragmentToMovieDetailsFragment(movieItem.id)
           findNavController().navigate(action)
        }

        return binding.root
    }

    @SuppressLint("ResourceAsColor")
    private fun updateButtonColors() {
        if (isPopularityButtonClicked) {
            binding.bFavorite.setBackgroundColor(
                ContextCompat.getColor(requireContext(),R.color.blue)
            )
            binding.bPopularity.setBackgroundColor(
                ContextCompat.getColor(requireContext(),R.color.blue_light)
            )
        } else if (isFavoriteButtonClicked) {
            binding.bFavorite.setBackgroundColor(
                ContextCompat.getColor(requireContext(),R.color.blue_light)
            )
            binding.bPopularity.setBackgroundColor(
                ContextCompat.getColor(requireContext(),R.color.blue)
            )
        }
    }

}
