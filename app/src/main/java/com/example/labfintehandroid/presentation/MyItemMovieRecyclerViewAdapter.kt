package com.example.labfintehandroid.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.labfintehandroid.databinding.FragmentMovieBinding
import com.example.labfintehandroid.domain.model.MovieItem


class MyItemMovieRecyclerViewAdapter() : ListAdapter<MovieItem, MyItemMovieRecyclerViewAdapter.MovieViewHolder>(
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
        val genre = itemMovie.genre


        binding.root.setOnClickListener {

        }

        Glide.with(context)
            .load(itemMovie.imagePreviewUrl)
            .centerCrop()
            .into(binding.imMovie)

        binding.tvtitle.text = itemMovie.title
        binding.tvData.text = genre.first().genre + "" + "(${itemMovie.data})"

        binding.root.setOnClickListener {
            clickItemMovie?.invoke(itemMovie)
        }


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