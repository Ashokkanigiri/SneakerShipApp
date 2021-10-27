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
        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                request.addHeader(
                    ConstantUtils.API_HOST_HEADER_KEY,
                    ConstantUtils.API_HOST_HEADER_VALUE
                )
                    .addHeader(
                        ConstantUtils.API_KEY_KEY,
                        ConstantUtils.API_KEY_VALUE
                    ).header("Cache-Control", "public, max-age=60")
                val response = chain.proceed(request.build())
                return@addInterceptor response
            }.addInterceptor(loggingInterceptor).build()
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