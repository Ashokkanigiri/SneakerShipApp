package com.ashok.kanigiri.sneakershipapp.feature.home.view.viewholder

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.ashok.kanigiri.sneakershipapp.databinding.ItemHomeDataBinding
import com.ashok.kanigiri.sneakershipapp.feature.home.viewmodel.HomeViewModel
import com.ashok.kanigiri.sneakershipapp.services.room.models.Sneaker
import com.bumptech.glide.Glide

class HomeDataViewHolder(val binding: ItemHomeDataBinding, val viewmodel: HomeViewModel): RecyclerView.ViewHolder(binding.root) {
    fun bind(sneaker: Sneaker){
        binding.sneaker = sneaker
        binding.viewmodel = viewmodel
    }
}