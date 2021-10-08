package com.example.mynewsapp.service.di.modules.viewmodelmodule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

//    @Binds
//    @IntoMap
//    @ViewModelKey(SplashViewModel::class)
//    abstract fun bindsSplashviewModel(splashViewModel: SplashViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(HeadlineViewModel::class)
//    abstract fun bindsHeadlineViewModel(headlinesViewmodel: HeadlineViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(HeadlineDetailViewModel::class)
//    abstract fun bindsHeadlineDetailViewModel(headlineDetailViewModel: HeadlineDetailViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(SearchViewModel::class)
//    abstract fun bindsSearchViewModel(headlineDetailViewModel: SearchViewModel): ViewModel

    @Binds
    abstract fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}