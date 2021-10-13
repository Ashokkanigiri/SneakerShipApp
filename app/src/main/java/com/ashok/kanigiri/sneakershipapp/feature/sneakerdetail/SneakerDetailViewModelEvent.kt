package com.ashok.kanigiri.sneakershipapp.feature.sneakerdetail

import com.ashok.kanigiri.sneakershipapp.services.room.models.Sneaker

sealed class SneakerDetailViewModelEvent{
    data class GetSneaker(val sneaker: Sneaker?): SneakerDetailViewModelEvent()
}
