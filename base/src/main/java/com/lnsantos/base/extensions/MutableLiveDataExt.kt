package com.lnsantos.base.extensions

import androidx.lifecycle.MutableLiveData

fun<T> MutableLiveData<T>.changeValue(data : T){
    value = data
}