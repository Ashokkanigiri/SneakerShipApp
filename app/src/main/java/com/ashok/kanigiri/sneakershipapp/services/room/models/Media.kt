package com.ashok.kanigiri.sneakershipapp.services.room.models

import com.google.gson.annotations.SerializedName

data class Media(
    @SerializedName("imageUrl") val imageUrl: String?,
    @SerializedName("smallImageUrl") val smallImageUrl: String?,
    @SerializedName("thumbUrl") val thumbUrl: String?
)
