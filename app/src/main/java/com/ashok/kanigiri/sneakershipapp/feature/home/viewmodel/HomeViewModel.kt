package com.ashok.kanigiri.sneakershipapp.feature.home.viewmodel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashok.kanigiri.sneakershipapp.SneakerShipApplication
import com.ashok.kanigiri.sneakershipapp.feature.home.HomeViewModelEvent
import com.ashok.kanigiri.sneakershipapp.feature.home.view.HomeDataAdapter
import com.ashok.kanigiri.sneakershipapp.services.rest.RestApiSource
import com.ashok.kanigiri.sneakershipapp.services.room.RoomDataSource
import com.ashok.kanigiri.sneakershipapp.services.room.models.Sneaker
import com.ashok.kanigiri.sneakershipapp.utils.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val restApiSource: RestApiSource, private val roomDataSource: RoomDataSource, private val application: SneakerShipApplication) : ViewModel() {

    val event: SingleLiveEvent<HomeViewModelEvent> = SingleLiveEvent()
    val progressbarVisibility = SingleLiveEvent<Boolean>()
    val HOME_DATA_GRID_SPAN_COUNT = 2
    private val adapter = HomeDataAdapter(this)

    fun setAdapter(): HomeDataAdapter {
        return adapter
    }

    fun loadData(){
        progressbarVisibility.postValue(true)
        viewModelScope.launch (Dispatchers.IO){
            val sneakersList = restApiSource.getSneakerRepository().getAllSneakers()
            sneakersList?.let {event.postValue(HomeViewModelEvent.GetAllSneakers(sneakersList))  }
            progressbarVisibility.postValue(false)
        }
    }

    fun loadAdapter(sneakersList: List<Sneaker>) {
        adapter.submitList(sneakersList)
    }

    fun navigateToSneakerDetail(sneakerId: String){
        event.postValue(HomeViewModelEvent.NavigateToSneakerDetail(sneakerId))
    }

    fun addSneakerToCart(sneaker: Sneaker){
        viewModelScope.launch(Dispatchers.IO) {
            roomDataSource.getSneakerDao().insertSneakers(sneaker)
        }
        Toast.makeText(application, "Item Sucessfully added to cart", Toast.LENGTH_SHORT).show()
    }

}