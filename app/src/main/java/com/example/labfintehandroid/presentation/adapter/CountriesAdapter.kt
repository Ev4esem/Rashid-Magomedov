package com.example.labfintehandroid.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.labfintehandroid.databinding.ItemTextBinding
import com.example.labfintehandroid.domain.model.Countries

class CountriesAdapter(
    private val itemList: List<Countries>,
) : RecyclerView.Adapter<CountriesAdapter.CountryViewHolder>() {


    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : CountryViewHolder {
        val binding = ItemTextBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CountryViewHolder(binding)
    }

    override fun getItemCount() : Int = itemList.size

    override fun onBindViewHolder(holder : CountryViewHolder, position : Int) {

        val item = itemList[position]
        holder.bind(item)
    }
    class CountryViewHolder(val binding : ItemTextBinding) : ViewHolder(binding.root) {
        fun bind(country : Countries) {
            binding.tvText.text = country.country
        }
    }

}