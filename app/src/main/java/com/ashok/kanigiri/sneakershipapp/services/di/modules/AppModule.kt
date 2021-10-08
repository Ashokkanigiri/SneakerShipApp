package com.example.mynewsapp.service.di.modules

import com.ashok.kanigiri.sneakershipapp.utils.ConstantUtils
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {


    @Provides
    @Singleton
    fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Provides
    @Singleton
    fun getOkHttpClientBuilder(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val client =  OkHttpClient.Builder()
//            .addInterceptor { chain ->
//                val request = chain.request().newBuilder()
//                val originalHttpUrl = chain.request().url
//                val url = originalHttpUrl.newBuilder()
//                    .addQueryParameter("x-rapidapi-host", "v1-sneakers.p.rapidapi.com")
//                    .addQueryParameter("x-rapidapi-key", "4cec5f2946msh1a15fa0fd31658ep135f7fjsn8a4dda67eae7").build()
//                request.url(url)
//                val response = chain.proceed(request.build())
//                return@addInterceptor response
//            }.addInterceptor(loggingInterceptor).build()
            .addInterceptor(loggingInterceptor).build()
        return client
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