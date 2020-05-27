package com.example.weatherhere.home.domain

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {


    fun getClient(): Retrofit {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.metaweather.com/api/location/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit

    }
}