package com.example.weatherhere.home.domain

data class WeatherIdItem(
    val latt_long: String,
    val location_type: String,
    val title: String,
    val woeid: Int
)