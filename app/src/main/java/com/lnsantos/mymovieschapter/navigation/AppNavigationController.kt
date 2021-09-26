package com.lnsantos.mymovieschapter.navigation

import com.lnsantos.base.navigation.BaseFragment
import com.lnsantos.base.navigation.NavigationController
import com.lnsantos.base.navigation.model.FragmentData
import com.lnsantos.base.navigation.model.FragmentId
import com.lnsantos.signin.SignInFragment
import com.lnsantos.signup.SignUpFragment


class AppNavigationController : NavigationController {

    override fun build(fragmentData: FragmentData): BaseFragment {

        return when(fragmentData.id){

            FragmentId.SIGN_IN -> {
                SignInFragment().apply {
                    arguments = fragmentData.bundle
                }
            }

            FragmentId.SIGN_UP -> {
                SignUpFragment().apply {
                    arguments = fragmentData.bundle
                }
            }

            else -> SignInFragment()
        }
    }
}