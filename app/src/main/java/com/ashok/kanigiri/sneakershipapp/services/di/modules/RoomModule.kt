package com.example.mynewsapp.service.di.modules

import androidx.room.Room
import com.ashok.kanigiri.sneakershipapp.SneakerShipApplication
import com.ashok.kanigiri.sneakershipapp.services.room.SneakerDatabase
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

//    @Singleton
//    @Provides
//    fun providesCategorysDao(myAppDatabase: MyAppDatabase): CategoriesDao{
//        return myAppDatabase.getCategorysDao()
//    }
//
//    @Singleton
//    @Provides
//    fun providesRoomRepository(categoriesDao: CategoriesDao): RoomDataSource{
//        return RoomDataSource(categoriesDao)
//    }
}