package com.lnsantos.mymovieschapter.extensions

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lnsantos.base.extensions.goToPage
import com.lnsantos.base.inflateFragmentInView
import com.lnsantos.base.navigation.model.FragmentData
import com.lnsantos.mymovieschapter.navigation.AppNavigationController
import com.lnsantos.signin.SignInFragment

fun AppCompatActivity.startInflateFragment(
    view : View,
    data: FragmentData
){
    try {
        val fragment = AppNavigationController().build(data)
        inflateFragmentInView(view, fragment)
    } catch (e: Exception){
        SignInFragment().goToPage()
    }

}