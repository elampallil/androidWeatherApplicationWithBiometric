package com.example.weatherhere.home.presentation

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherhere.base.SingleLiveEvent
import com.example.weatherhere.home.data.RepoService
import com.example.weatherhere.home.domain.RetrofitInstance
import com.example.weatherhere.home.domain.WeatherData
import com.example.weatherhere.home.domain.WeatherId
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val sumbmitButtonClickLiveData = MutableLiveData<SingleLiveEvent<Boolean>>()
    private val weatherResponseLiveData = MutableLiveData<WeatherData>()
    private val findMyLocationLiveData = MutableLiveData<SingleLiveEvent<Boolean>>()
    fun getWeatherResponseLiveData() : LiveData<WeatherData> = weatherResponseLiveData
    fun getSumbmitButtonClickLiveData(): LiveData<SingleLiveEvent<Boolean>> =
        sumbmitButtonClickLiveData
    fun getFindMyLocationLiveData():LiveData<SingleLiveEvent<Boolean>> =findMyLocationLiveData

    private val retrofitInstance = RetrofitInstance()

    fun getWeatherDetails(place: String) {
        val retrofit = retrofitInstance.getClient().create(RepoService::class.java)
        val repo = retrofit.getCountryId(place)
        repo.enqueue(object : Callback<WeatherId> {
            override fun onFailure(call: Call<WeatherId>?, t: Throwable?) {

            }

            override fun onResponse(
                call: Call<WeatherId>?,
                response: Response<WeatherId>?
            ) {
                if (response?.body()?.size != 0) {
                    val weatherId = response?.body()?.get(0)?.woeid
                    weatherId?.let {
                        getWeatherFullDetails(it)
                    }
                } else {
                    val toast = Toast.makeText(
                        getApplication(),
                        "No Result found for this place",
                        Toast.LENGTH_SHORT
                    )
                    toast.show()
                }

            }
        })

    }

    fun getWeatherFullDetails(id: Int) {

        val retrofit = retrofitInstance.getClient().create(RepoService::class.java)
        val repo = retrofit.getWeaterFullDetails(id)
        repo.enqueue(object : Callback<WeatherData> {
            override fun onFailure(call: Call<WeatherData>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<WeatherData>?, response: Response<WeatherData>?) {
                weatherResponseLiveData.value =response?.body()
            }
        })
    }

    fun onClickSumbitButton() {
        sumbmitButtonClickLiveData.value = SingleLiveEvent(true)
    }
    fun onClickFindMyLocation() {
        findMyLocationLiveData.value = SingleLiveEvent(true)
    }
}
