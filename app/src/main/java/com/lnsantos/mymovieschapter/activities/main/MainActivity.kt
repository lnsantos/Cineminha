package com.lnsantos.mymovieschapter.activities.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    }

}