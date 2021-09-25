package com.lnsantos.base

import android.content.Context
import android.content.Intent

fun Context.nextActivity(nextActivity : Class<*>, customFlags: ArrayList<Int> = arrayListOf()){

    val intent = Intent(this, nextActivity).apply {
        customFlags.forEach { flag -> flags = flag }
        cleanAllActivity()
    }

    startActivity(intent)
}