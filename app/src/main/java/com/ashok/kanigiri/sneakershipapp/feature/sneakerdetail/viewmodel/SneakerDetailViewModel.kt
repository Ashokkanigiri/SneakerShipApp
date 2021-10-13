package com.ashok.kanigiri.sneakershipapp.feature.sneakerdetail.viewmodel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashok.kanigiri.sneakershipapp.SneakerShipApplication
import com.ashok.kanigiri.sneakershipapp.feature.sneakerdetail.SneakerDetailViewModelEvent
import com.ashok.kanigiri.sneakershipapp.services.rest.RestApiSource
import com.ashok.kanigiri.sneakershipapp.services.room.RoomDataSource
import com.ashok.kanigiri.sneakershipapp.services.room.models.Sneaker
import com.ashok.kanigiri.sneakershipapp.utils.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SneakerDetailViewModel @Inject constructor(
    private val restApiSource: RestApiSource,
    private val roomDataSource: RoomDataSource,
    private val application: SneakerShipApplication
) :
    ViewModel() {

    var sneakerId: String? = null

    val progressBarVisibility = SingleLiveEvent<Boolean>()
    val event: SingleLiveEvent<SneakerDetailViewModelEvent> = SingleLiveEvent()

    fun getSneaker(sneakerId: String) {
        progressBarVisibility.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            val sneaker =
                restApiSource.getSneakerRepository().getSneaker(sneakerId)
            event.postValue(
                SneakerDetailViewModelEvent.GetSneaker(sneaker)
            )
            progressBarVisibility.postValue(false)
        }
    }

    private fun addSneakerToCart(sneaker: Sneaker) {
        viewModelScope.launch(Dispatchers.IO) {
            roomDataSource.getSneakerDao().insertSneakers(sneaker)
        }
    }

    fun addToCart(sneaker: Sneaker) {
        addSneakerToCart(sneaker)
        Toast.makeText(application, "Item Sucessfully added to cart", Toast.LENGTH_SHORT).show()
    }
}