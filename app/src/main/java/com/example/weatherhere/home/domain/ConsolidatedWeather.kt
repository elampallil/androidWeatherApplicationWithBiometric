package com.example.weatherhere.home.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ConsolidatedWeather(
    val air_pressure: Double=0.0,
    val applicable_date: String="",
    val created: String="",
    val humidity: Int=1,
    val id: Long=11111111111,
    val max_temp: Double=0.0,
    val min_temp: Double=0.0,
    val predictability: Int=1,
    val the_temp: Double=0.0,
    val visibility: Double=0.0,
    val weather_state_abbr: String="",
    val weather_state_name: String="",
    val wind_direction: Double=0.0,
    val wind_direction_compass: String="",
    val wind_speed: Double=0.0
) : Parcelable