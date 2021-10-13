package com.example.mynewsapp.service.di.modules
import com.ashok.kanigiri.sneakershipapp.feature.addtocart.view.AddToCartFragment
import com.ashok.kanigiri.sneakershipapp.feature.home.view.HomeFragment
import com.ashok.kanigiri.sneakershipapp.feature.sneakerdetail.SneakerDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributesHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributesSneakerDetail(): SneakerDetailFragment

    @ContributesAndroidInjector
    abstract fun contributesAddToCartFragment(): AddToCartFragment
}