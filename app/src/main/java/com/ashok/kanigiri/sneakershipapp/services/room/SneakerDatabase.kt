package com.ashok.kanigiri.sneakershipapp.services.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ashok.kanigiri.sneakershipapp.services.room.models.Sneaker

@Database(entities = [Sneaker::class], version = 1, exportSchema = false)
abstract class SneakerDatabase: RoomDatabase() {
}