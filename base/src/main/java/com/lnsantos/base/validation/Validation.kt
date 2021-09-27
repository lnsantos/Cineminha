package com.lnsantos.base.validation

import java.lang.Exception

class Validation {

    private var dataString : String? = null

    companion object {
        const val EMAIL = 1
    }

    fun validateString(data: String?) : Validation{
        dataString = data
        return this
    }

    fun build(type: Int) : Boolean {

        if (dataString.isNullOrBlank()){
            throw Exception("validateString not call")
        }

        return when(type){
            EMAIL -> validateEmailFromISO(dataString.toString())
            else -> throw Exception("type not found")
        }
    }

    private fun validateEmailFromISO(email : String) : Boolean {
        return ValidationRegex.email.toRegex().containsMatchIn(email)
    }

}