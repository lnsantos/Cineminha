package com.lnsantos.mymovieschapter.activities.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lnsantos.base.navigation.BaseFragment
import com.lnsantos.base.navigation.NavigationListener
import com.lnsantos.base.navigation.NavigationManager
import com.lnsantos.base.navigation.model.FragmentData
import com.lnsantos.base.navigation.model.FragmentId
import com.lnsantos.mymovieschapter.R
import com.lnsantos.mymovieschapter.databinding.ActivityAppBinding

class AppActivity : AppCompatActivity(), NavigationListener{

    private lateinit var binding : ActivityAppBinding

    override fun onStart() {
        super.onStart()
        NavigationManager.onNavigationConnection(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_app)

        binding.colorBlack.setOnClickListener {}
        binding.colorBlue.setOnClickListener {}

    }

    override fun onNextFragment(data: FragmentData?) {
        binding.constraint.background = getDrawable(R.color.black)
    }

    override fun onBackFragment(data: FragmentData?) {
        binding.constraint.background = getDrawable(R.color.blue_070)
    }

}
