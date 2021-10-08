package com.example.mynewsapp.service.di

import com.ashok.kanigiri.sneakershipapp.SneakerShipApplication
import com.example.mynewsapp.service.di.modules.*
import com.example.mynewsapp.service.di.modules.viewmodelmodule.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class, AppModule::class, RoomModule::class, MainActivityModule::class, ViewModelModule::class, FragmentModule::class, AppAssistedInjectModule::class]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: SneakerShipApplication): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: SneakerShipApplication)
}