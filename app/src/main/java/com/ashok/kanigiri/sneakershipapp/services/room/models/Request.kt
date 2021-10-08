package com.ashok.kanigiri.sneakershipapp.services.room.models

import com.google.gson.annotations.SerializedName

data class Request(
    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: List<Sneaker>
)

