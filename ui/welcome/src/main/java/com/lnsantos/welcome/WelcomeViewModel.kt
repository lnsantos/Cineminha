package com.lnsantos.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lnsantos.base.navigation.model.FragmentId
import com.lnsantos.base_clean.ResultClean
import java.lang.Exception

internal class WelcomeViewModel : ViewModel(){

    private val _nextPage = MutableLiveData<ResultClean<FragmentId>>()
    val nextPage : LiveData<ResultClean<FragmentId>> = _nextPage

    fun onNextPage(data : FragmentId){

        val responseNotify = try {
            ResultClean.Success(data)
        } catch (e: Exception){
            ResultClean.Error("Error", e)
        }

        _nextPage.postValue(responseNotify)
    }

}