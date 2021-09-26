package com.lnsantos.base.navigation

import com.lnsantos.base.navigation.model.FragmentData

interface NavigationListener {

    fun onNextFragment(data: FragmentData?)
    fun onBackFragment(data: FragmentData?)

}