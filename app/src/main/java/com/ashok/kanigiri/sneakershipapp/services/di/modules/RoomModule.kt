package com.example.mynewsapp.service.di.modules

import androidx.room.Room
import com.ashok.kanigiri.sneakershipapp.SneakerShipApplication
import com.ashok.kanigiri.sneakershipapp.services.room.RoomDataSource
import com.ashok.kanigiri.sneakershipapp.services.room.SneakerDatabase
import com.ashok.kanigiri.sneakershipapp.services.room.dao.SneakerDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Singleton
    @Provides
    fun providesRoomDatabase(application: SneakerShipApplication): SneakerDatabase{
        return Room.databaseBuilder(application, SneakerDatabase::class.java, "sneaker-database")
            .allowMainThreadQueries().build()
    }

    @Singleton
    @Provides
    fun providesSneakersDao(sneakerDatabase: SneakerDatabase): SneakerDao{
        return sneakerDatabase.getSneakerDao()
    }

    @Singleton
    @Provides
    fun providesRoomRepository(sneakerDao: SneakerDao): RoomDataSource {
        return RoomDataSource(sneakerDao)
    }
}