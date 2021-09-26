package com.lnsantos.base_clean

sealed class ResultClean<out T : Any> {
    data class Success<out T : Any>(val value: T) : ResultClean<T>()
    data class Error(val message: String, val cause: Exception? = null) : ResultClean<Nothing>()
    object Loading : ResultClean<Nothing>()
}
