package com.ashok.kanigiri.sneakershipapp.services.room.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Sneaker(
    @PrimaryKey
    val id: String,
    val brand: String,
    val colorway: String,
    val gender: String,
    @Embedded
    val media: Media,
    val releaseDate: String,
    val retailPrice: String,
    val styleId: String,
    val shoe: String,
    val name: String,
    val title: String,
    val year: String
)
