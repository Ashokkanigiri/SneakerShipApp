package com.example.mynewsapp.service.di.modules
import com.ashok.kanigiri.sneakershipapp.feature.home.view.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributesHomeFragment(): HomeFragment
}