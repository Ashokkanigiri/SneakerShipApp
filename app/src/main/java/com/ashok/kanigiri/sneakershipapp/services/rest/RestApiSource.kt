package com.ashok.kanigiri.sneakershipapp.services.rest

import javax.inject.Inject

class RestApiSource @Inject constructor(private val sneakerRepository: SneakerRepository) {
    fun getSneakerRepository() = sneakerRepository
}