package com.ashok.kanigiri.sneakershipapp.services.rest

import retrofit2.Retrofit
import javax.inject.Inject

class RestApiService @Inject constructor(private val retrofit: Retrofit) {
    fun getSneakerClient() = retrofit.create(SneakerRestClient::class.java)
}