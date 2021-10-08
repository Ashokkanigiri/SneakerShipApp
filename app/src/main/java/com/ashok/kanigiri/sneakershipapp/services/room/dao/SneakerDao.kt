package com.ashok.kanigiri.sneakershipapp.services.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ashok.kanigiri.sneakershipapp.services.room.models.Sneaker

@Dao
interface SneakerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSneakers(sneakers: List<Sneaker>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSneakers(sneakers: Sneaker)

    @Query("SELECT * FROM sneaker")
    fun getAllSneakers(): LiveData<List<Sneaker>>
}