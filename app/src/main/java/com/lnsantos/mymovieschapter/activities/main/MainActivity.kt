package com.lnsantos.mymovieschapter.activities.main

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.telephony.TelephonyManager
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.lnsantos.base.nextActivity
import com.lnsantos.mymovieschapter.R
import com.lnsantos.mymovieschapter.activities.app.AppActivity
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        Executors.newSingleThreadScheduledExecutor().schedule({
            nextActivity(AppActivity::class.java)
        }, 3, TimeUnit.SECONDS)

        deviceInfoLog()
    }

    private fun deviceInfoLog() {

        val tm = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        val networkOperator = tm.networkOperatorName
        val isEmulator =  "Android" == networkOperator || "Telet" == networkOperator

        Log.i("TAG_MAIN", " is emulator -> ${isEmulator}")

        Log.i("TAG_MAIN","""
            \n
            Operadora: $networkOperator
            
            PRODUCT : ${Build.PRODUCT}
            MANUFACTURER : ${Build.MANUFACTURER}
            BRAND : ${Build.BRAND}
            DEVICE : ${Build.DEVICE}
            MODEL : ${Build.MODEL}
            HARDWARE : ${Build.HARDWARE}
            FINGERPRINT : ${Build.FINGERPRINT}
        """.trimIndent())
    }

}