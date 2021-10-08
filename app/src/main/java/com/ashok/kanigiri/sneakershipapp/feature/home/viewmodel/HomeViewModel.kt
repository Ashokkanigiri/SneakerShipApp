package com.ashok.kanigiri.sneakershipapp.feature.home.viewmodel

import androidx.lifecycle.ViewModel
import com.ashok.kanigiri.sneakershipapp.feature.home.view.HomeDataAdapter
import com.ashok.kanigiri.sneakershipapp.services.room.models.Sneaker
import javax.inject.Inject

class HomeViewModel @Inject constructor(): ViewModel() {

    private val adapter = HomeDataAdapter(this)
     val HOME_DATA_GRID_SPAN_COUNT = 2

    fun setAdapter(): HomeDataAdapter{
        return adapter
    }

    fun loadAdapter(sneakersList: List<Sneaker>){
        adapter.submitList(sneakersList)
    }
}