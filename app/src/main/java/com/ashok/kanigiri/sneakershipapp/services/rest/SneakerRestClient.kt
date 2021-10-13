package com.ashok.kanigiri.sneakershipapp.services.rest

import com.ashok.kanigiri.sneakershipapp.services.room.models.Request
import com.ashok.kanigiri.sneakershipapp.services.room.models.Sneaker
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface SneakerRestClient {

    @GET("v1/sneakers")
    suspend fun getAllSneakers(
        @Query("limit") limit: String = "100"
    ): Response<Request>

    @GET("v1/sneakers/{sneakerId}")
    suspend fun getSneaker(@Path("sneakerId") sneakerId: String): Response<Request>
}