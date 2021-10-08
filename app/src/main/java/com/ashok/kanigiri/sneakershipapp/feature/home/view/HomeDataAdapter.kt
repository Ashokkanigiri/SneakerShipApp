package com.ashok.kanigiri.sneakershipapp.feature.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ashok.kanigiri.sneakershipapp.MainActivityViewModel
import com.ashok.kanigiri.sneakershipapp.R
import com.ashok.kanigiri.sneakershipapp.databinding.ItemHomeDataBinding
import com.ashok.kanigiri.sneakershipapp.feature.home.view.viewholder.HomeDataViewHolder
import com.ashok.kanigiri.sneakershipapp.feature.home.viewmodel.HomeViewModel
import com.ashok.kanigiri.sneakershipapp.services.room.models.Sneaker

class HomeDataAdapter (val viewModel: HomeViewModel) : ListAdapter<Sneaker, HomeDataViewHolder>(HomeDiffUtil()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeDataViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemHomeDataBinding>(inflator, R.layout.item_home_data, parent, false)
        return HomeDataViewHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: HomeDataViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class HomeDiffUtil: DiffUtil.ItemCallback<Sneaker>(){
    override fun areItemsTheSame(oldItem: Sneaker, newItem: Sneaker): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Sneaker, newItem: Sneaker): Boolean {
        return oldItem.id == newItem.id
    }
}
