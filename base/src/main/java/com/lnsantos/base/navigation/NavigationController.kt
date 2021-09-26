package com.lnsantos.base.navigation

import com.lnsantos.base.navigation.model.FragmentData

interface NavigationController {
    fun build(fragmentData: FragmentData) : BaseFragment
}