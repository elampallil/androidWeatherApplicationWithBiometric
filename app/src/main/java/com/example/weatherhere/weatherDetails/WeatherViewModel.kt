package com.example.weatherhere.weatherDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherhere.base.SingleLiveEvent
import com.example.weatherhere.home.domain.ConsolidatedWeather

class WeatherViewModel : ViewModel() {
    val airPressureLiveData = MutableLiveData<String>()
    val humidityLiveData = MutableLiveData<String>()
    val temperatureLiveData = MutableLiveData<String>()
    val visibilityLiveData = MutableLiveData<String>()
    val windDirectionLiveData = MutableLiveData<String>()
    val windSpeedLiveData = MutableLiveData<String>()
    private val backIconClickLiveData = MutableLiveData<SingleLiveEvent<Boolean>>()
    fun getBackIconClickLiveData(): LiveData<SingleLiveEvent<Boolean>> = backIconClickLiveData


    fun setWeatherDetailsToLiveData(consolidateWeather: ConsolidatedWeather) {

        airPressureLiveData.value = consolidateWeather.air_pressure.toString()
        humidityLiveData.value = consolidateWeather.humidity.toString()
        temperatureLiveData.value = consolidateWeather.the_temp.toString()
        visibilityLiveData.value = consolidateWeather.visibility.toString()
        windDirectionLiveData.value = consolidateWeather.wind_direction.toString()
        windSpeedLiveData.value = consolidateWeather.wind_speed.toString()

    }

    fun onClickBackButton() {
        backIconClickLiveData.value = SingleLiveEvent(true)
    }
}
