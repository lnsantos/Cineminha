package com.lnsantos.mymovieschapter.activities.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lnsantos.base.extensions.goToPage
import com.lnsantos.base.navigation.NavigationListener
import com.lnsantos.base.navigation.NavigationManager
import com.lnsantos.base.navigation.OnBackPressed
import com.lnsantos.base.navigation.model.FragmentData
import com.lnsantos.base.safeFragmentInstance
import com.lnsantos.mymovieschapter.R
import com.lnsantos.mymovieschapter.databinding.ActivityAppBinding
import com.lnsantos.mymovieschapter.extensions.startInflateFragment
import com.lnsantos.welcome.WelcomeFragment
import java.lang.Exception

class AppActivity : AppCompatActivity(), NavigationListener {

    private lateinit var binding : ActivityAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_app)
        NavigationManager.onNavigationConnection(this)
        NavigationManager.onCreate()
        WelcomeFragment().goToPage()
    }

    override fun onNextFragment(data: FragmentData?) = inflateView(data)
    override fun onBackFragment(data: FragmentData?) = inflateView(data)

    private fun inflateView(data: FragmentData?){
        data.safeFragmentInstance(
            { success -> startInflateFragment(binding.singleActivityContainer, success) },
            { _ -> WelcomeFragment().goToPage() }
        )
    }

    override fun onBackPressed() {
        try {
            val containerId = binding.singleActivityContainer.id
            val fragment = supportFragmentManager.findFragmentById(containerId)
            val backPressed = (fragment as OnBackPressed)

            if (backPressed.onBackPressed()){
                NavigationManager.onBackFragment()
            } else {
                super.onBackPressed()
            }

        } catch (e: Exception){
            super.onBackPressed()
        }
    }


}
