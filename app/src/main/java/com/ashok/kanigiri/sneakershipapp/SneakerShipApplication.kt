package com.ashok.kanigiri.sneakershipapp

import android.app.Application
import com.example.mynewsapp.service.di.ApplicationInjector
import com.example.mynewsapp.service.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class SneakerShipApplication: Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        val daggerComponent = DaggerApplicationComponent.builder().application(this).build()

        ApplicationInjector.init(this) { newsApplication ->
            daggerComponent.inject(newsApplication)
        }
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

}