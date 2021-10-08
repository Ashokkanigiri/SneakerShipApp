package com.ashok.kanigiri.sneakershipapp.services.room.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Sneaker(
    @PrimaryKey
    @SerializedName("id") val id : String,
    @SerializedName("brand") val brand : String,
    @SerializedName("colorway") val colorway : String,
    @SerializedName("gender") val gender : String,
    @SerializedName("name") val name : String,
    @SerializedName("releaseDate") val releaseDate : String,
    @SerializedName("retailPrice") val retailPrice : Int,
    @SerializedName("shoe") val shoe : String,
    @SerializedName("styleId") val styleId : String,
    @SerializedName("title") val title : String,
    @SerializedName("year") val year : Int,
    @Embedded
    @SerializedName("media") val media : Media
)
