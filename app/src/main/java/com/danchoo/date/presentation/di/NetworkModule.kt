package com.danchoo.date.presentation.di

import com.danchoo.category.data.remote.api.CategoryApiInterface
import com.danchoo.category.data.remote.api.ContentsApiInterface
import com.danchoo.retrofitutils.RetrofitCreateHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://api/v1/"

    @Singleton
    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        return RetrofitCreateHelper
            .providesOkHttpClient()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return RetrofitCreateHelper
            .provideRetrofit(BASE_URL, okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiInterface =
        retrofit.create(ApiInterface::class.java)


    interface ApiInterface : CategoryApiInterface, ContentsApiInterface
}