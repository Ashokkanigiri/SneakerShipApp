package com.ashok.kanigiri.sneakershipapp.feature.addtocart.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ashok.kanigiri.sneakershipapp.MainActivityViewModel
import com.ashok.kanigiri.sneakershipapp.R
import com.ashok.kanigiri.sneakershipapp.databinding.ItemAddToCartBinding
import com.ashok.kanigiri.sneakershipapp.databinding.ItemHomeDataBinding
import com.ashok.kanigiri.sneakershipapp.feature.addtocart.viewmodel.AddToCartViewModel
import com.ashok.kanigiri.sneakershipapp.feature.home.view.viewholder.HomeDataViewHolder
import com.ashok.kanigiri.sneakershipapp.feature.home.viewmodel.HomeViewModel
import com.ashok.kanigiri.sneakershipapp.services.room.models.Sneaker

class AddToCartAdapter (val viewModel: AddToCartViewModel) : ListAdapter<Sneaker, AddToCartViewHolder>(AddToCartDiffUtil()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddToCartViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemAddToCartBinding>(inflator, R.layout.item_add_to_cart, parent, false)
        return AddToCartViewHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: AddToCartViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class AddToCartDiffUtil: DiffUtil.ItemCallback<Sneaker>(){
    override fun areItemsTheSame(oldItem: Sneaker, newItem: Sneaker): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Sneaker, newItem: Sneaker): Boolean {
        return oldItem.id == newItem.id
    }
}
