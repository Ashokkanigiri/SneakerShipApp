package com.ashok.kanigiri.sneakershipapp.feature.addtocart.view

import androidx.recyclerview.widget.RecyclerView
import com.ashok.kanigiri.sneakershipapp.databinding.ItemAddToCartBinding
import com.ashok.kanigiri.sneakershipapp.feature.addtocart.viewmodel.AddToCartViewModel
import com.ashok.kanigiri.sneakershipapp.services.room.models.Sneaker

class AddToCartViewHolder(val binding: ItemAddToCartBinding, val viewmodel: AddToCartViewModel): RecyclerView.ViewHolder(binding.root){

    fun bind(sneaker: Sneaker){
        binding.sneaker = sneaker
        binding.viewmodel = viewmodel
    }

}