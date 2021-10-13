package com.ashok.kanigiri.sneakershipapp.feature.home

import com.ashok.kanigiri.sneakershipapp.services.room.models.Sneaker

sealed class HomeViewModelEvent{
    data class NavigateToSneakerDetail(val sneakerId: String): HomeViewModelEvent()
    data class GetAllSneakers(val sneakerList: List<Sneaker>): HomeViewModelEvent()
}

