package com.example.weatherhere.base

import androidx.annotation.Keep

@Keep
open class SingleLiveEvent<out T>(private val content: T) {
    private  var hasBeenHandled = false
    fun getContentIfNotHandld(): T? {
        return if (hasBeenHandled){
            null
        }
        else{
            hasBeenHandled = true
            content
        }
    }
    @Suppress("unused")
    fun peekContent() : T =content


}