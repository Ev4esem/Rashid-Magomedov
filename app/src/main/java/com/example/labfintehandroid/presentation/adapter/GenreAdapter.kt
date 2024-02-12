package com.example.labfintehandroid.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.labfintehandroid.databinding.ItemTextBinding
import com.example.labfintehandroid.domain.model.Genre


class GenreAdapter(
    private val itemList: List<Genre>,
) : RecyclerView.Adapter<GenreAdapter.GenreViewHolder>() {


    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : GenreViewHolder {
        val binding = ItemTextBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GenreViewHolder(binding)
    }

    override fun getItemCount() : Int = itemList.size

    override fun onBindViewHolder(holder : GenreViewHolder, position : Int) {

        val item = itemList[position]
        holder.bind(item)
    }
    class GenreViewHolder(val binding : ItemTextBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(genre : Genre) {
            binding.tvText.text = genre.genre
        }
    }

}