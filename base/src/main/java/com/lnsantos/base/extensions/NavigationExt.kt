package com.lnsantos.base.extensions

import com.lnsantos.base.navigation.BaseFragment
import com.lnsantos.base.navigation.NavigationManager

fun BaseFragment.goToPage(){
    NavigationManager.addFragment(fragmentData)
}