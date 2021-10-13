package com.example.mynewsapp.service.di.modules.viewmodelmodule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ashok.kanigiri.sneakershipapp.MainActivityViewModel
import com.ashok.kanigiri.sneakershipapp.feature.addtocart.viewmodel.AddToCartViewModel
import com.ashok.kanigiri.sneakershipapp.feature.home.viewmodel.HomeViewModel
import com.ashok.kanigiri.sneakershipapp.feature.sneakerdetail.viewmodel.SneakerDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindsHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindsMainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SneakerDetailViewModel::class)
    abstract fun bindsSneakerDetailViewModel(mainActivityViewModel: SneakerDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddToCartViewModel::class)
    abstract fun bindsAddToCartViewModel(mainActivityViewModel: AddToCartViewModel): ViewModel

    @Binds
    abstract fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}