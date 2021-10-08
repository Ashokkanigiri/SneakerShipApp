package com.ashok.kanigiri.sneakershipapp.services.rest

import com.ashok.kanigiri.sneakershipapp.services.room.models.Request
import com.ashok.kanigiri.sneakershipapp.services.room.models.Sneaker
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface SneakerRestClient {

    @GET("v1/sneakers")
    suspend fun getAllSneakers(
        @Header("x-rapidapi-host") apihost: String = "v1-sneakers.p.rapidapi.com",
        @Header("x-rapidapi-key") apiKey: String = "93b16cd2efmsh720f3abb89e52d7p1a57f4jsn6feb61489ce6",
        @Query("limit") limit: String = "10"
    ): Response<Request>
}