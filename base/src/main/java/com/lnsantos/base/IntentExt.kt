package com.lnsantos.base

import android.content.Intent

fun Intent.cleanAllActivity(){
    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
}