package com.danchoo.retrofitutils

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitCreateHelper {

    private const val DEFAULT_TIMEOUT = 30L

    fun providesOkHttpClient(
        interceptor: Interceptor = HttpInterceptor(),
        timeout: Long = DEFAULT_TIMEOUT,
    ): OkHttpClient.Builder =
        OkHttpClient
            .Builder()
            .connectTimeout(timeout, TimeUnit.SECONDS)
            .readTimeout(timeout, TimeUnit.SECONDS)
            .writeTimeout(timeout, TimeUnit.SECONDS)
            .addInterceptor(interceptor)

    fun provideRetrofit(
        baseUrl: String,
        okHttpClient: OkHttpClient,
        factory: Converter.Factory = MoshiConverterFactory.create()
    ): Retrofit.Builder = Retrofit.Builder()
        .addConverterFactory(factory)
        .baseUrl(baseUrl)
        .client(okHttpClient)
}