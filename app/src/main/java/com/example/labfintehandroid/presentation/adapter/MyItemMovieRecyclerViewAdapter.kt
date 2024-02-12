package com.example.labfintehandroid.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.labfintehandroid.R
import com.example.labfintehandroid.databinding.FragmentMovieBinding
import com.example.labfintehandroid.domain.model.MovieDetails
import com.example.labfintehandroid.domain.model.MovieItem
import com.example.labfintehandroid.domain.retrofit.Constant.MOVIE_ID


class MyItemMovieRecyclerViewAdapter(

) : ListAdapter<MovieItem, MyItemMovieRecyclerViewAdapter.MovieViewHolder>(
    MovieDiffCallback()
) {


    var clickItemMovie: ((MovieItem) -> Unit)? = null


    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : MovieViewHolder {

        return MovieViewHolder(
            FragmentMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder : MovieViewHolder, position : Int) {
        val itemMovie = getItem(position)
        val binding = holder.binding
        val context = binding.root.context
        binding.root.setOnClickListener {
            clickItemMovie?.invoke(itemMovie)
        }

        Glide.with(context)
            .load(itemMovie.imagePreviewUrl)
            .centerCrop()
            .into(binding.imMovie)

        val firstThreeGenres = itemMovie.genre.take(3)
        binding.tvtitle.text = itemMovie.title
        val genresString = firstThreeGenres.joinToString(", ") { it.genre }
        binding.tvData.text = genresString + "(${itemMovie.data})"




    }




    class MovieViewHolder(val binding : FragmentMovieBinding) : RecyclerView.ViewHolder(binding.root)
    class MovieDiffCallback : DiffUtil.ItemCallback<MovieItem>() {
        override fun areItemsTheSame(oldItem : MovieItem, newItem : MovieItem) : Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem : MovieItem, newItem : MovieItem) : Boolean {
            return oldItem == newItem
        }

    }

}