package com.ashok.kanigiri.sneakershipapp.services.room

import com.ashok.kanigiri.sneakershipapp.services.room.dao.SneakerDao
import javax.inject.Inject

class RoomDataSource @Inject constructor(private val sneakerDao: SneakerDao) {
    fun getSneakerDao() = sneakerDao
}