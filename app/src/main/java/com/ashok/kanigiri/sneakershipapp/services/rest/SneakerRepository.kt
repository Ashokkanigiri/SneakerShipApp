package com.ashok.kanigiri.sneakershipapp.services.rest

import com.ashok.kanigiri.sneakershipapp.services.room.models.Sneaker
import javax.inject.Inject

class SneakerRepository @Inject constructor(private val restApiService: RestApiService) {

    suspend fun getAllSneakers(): List<Sneaker>?{
        var response: List<Sneaker>? = null
        try {
            response = restApiService.getSneakerClient().getAllSneakers().body()?.results
        }catch (e: Exception){
            e.printStackTrace()
        }
        return response
    }
}