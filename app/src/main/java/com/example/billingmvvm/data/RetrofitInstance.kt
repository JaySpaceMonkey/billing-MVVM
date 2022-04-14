package com.example.billingmvvm.data

import android.app.Application
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.billingmvvm.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.Authenticator

object RetrofitInstance {



    private val okHttp = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp.build())
            .build()
    }

    val api: InterfaceApi by lazy{
        retrofit.create(InterfaceApi::class.java)
    }
}