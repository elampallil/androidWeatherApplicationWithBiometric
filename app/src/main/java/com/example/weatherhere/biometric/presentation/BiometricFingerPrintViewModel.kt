package com.example.weatherhere.biometric.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherhere.base.SingleLiveEvent

class BiometricFingerPrintViewModel : ViewModel() {
private  val buttonClickLiveData = MutableLiveData<SingleLiveEvent<Boolean>>()

    fun getButtonClickLiveData() : LiveData<SingleLiveEvent<Boolean>> = buttonClickLiveData
     fun onClickButton(){
         buttonClickLiveData.value = SingleLiveEvent(true)
     }
}
