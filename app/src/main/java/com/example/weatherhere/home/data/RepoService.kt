package com.example.weatherhere.home.data

import com.example.weatherhere.home.domain.WeatherData
import com.example.weatherhere.home.domain.WeatherId
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RepoService {


    @GET(value = "api/location/search/")
    fun getCountryId(@Query("query") query: String): Call<WeatherId>

    @GET(value ="api/location/{woeid}")
    fun getWeaterFullDetails(@Path(value = "woeid",encoded = true)woeid : Int) : Call<WeatherData>
}