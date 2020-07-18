package com.bibim.purpur.data.remote.retrofit


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkServiceImpl {
    private const val BASE_URL = "http://purpur.ml/"

    private val okHttpClient: OkHttpClient =
        OkHttpClient.Builder().addInterceptor(CookiesInterceptor())
            .addNetworkInterceptor(CookiesInterceptor()).build()

    private val retrofit: Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).client(
            okHttpClient
        )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val SERVICE: NetworkService = retrofit.create(
        NetworkService::class.java
    )
}