package com.ashok.kanigiri.sneakershipapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashok.kanigiri.sneakershipapp.services.rest.RestApiSource
import com.ashok.kanigiri.sneakershipapp.services.room.RoomDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val roomDataSource: RoomDataSource,
    private val restApiSource: RestApiSource
) : ViewModel() {

    fun injectSneakers(){
        viewModelScope.launch(Dispatchers.IO) {
            val sneakers = restApiSource.getSneakerRepository().getAllSneakers()
            sneakers?.let { roomDataSource.getSneakerDao().insertSneakers(it) }
        }
    }
}