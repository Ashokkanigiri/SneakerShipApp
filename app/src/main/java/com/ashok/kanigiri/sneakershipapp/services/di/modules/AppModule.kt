package com.example.mynewsapp.service.di.modules

import com.ashok.kanigiri.sneakershipapp.utils.ConstantUtils
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {


    @Provides
    @Singleton
    fun getOkHttpClientBuilder(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                val originalHttpUrl = chain.request().url()
                val url = originalHttpUrl.newBuilder()
                    .addQueryParameter("X-RapidAPI-Host", ConstantUtils.API_HOST_HEADER)
                    .addQueryParameter("X-RapidAPI-Key", ConstantUtils.API_KEY_HEADER).build()
                request.url(url)
                val response = chain.proceed(request.build())
                return@addInterceptor response
            }.build()
    }

    @Provides
    @Singleton
    fun providesRetrofitInstance(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(ConstantUtils.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

}