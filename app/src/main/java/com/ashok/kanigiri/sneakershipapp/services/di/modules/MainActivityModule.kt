package com.example.mynewsapp.service.di.modules

import com.ashok.kanigiri.sneakershipapp.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun contributesMainActivityModule(): MainActivity
}