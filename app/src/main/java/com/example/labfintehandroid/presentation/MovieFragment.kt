package com.example.labfintehandroid.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.labfintehandroid.Utils.Resource
import com.example.labfintehandroid.databinding.FragmentMovieListBinding
import com.example.labfintehandroid.domain.model.MovieItem
import com.example.labfintehandroid.domain.model.MovieList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment() {

    private lateinit var binding : FragmentMovieListBinding
    private val movieViewModel by viewModels<MovieViewModel>()

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

        movieAdapter.clickItemMovie = {
            findNavController().navigate()
        }

        return binding.root
    }

}
