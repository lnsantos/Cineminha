package com.lnsantos.base

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lnsantos.base.navigation.BaseFragment
import com.lnsantos.base.navigation.model.FragmentData
import java.lang.Exception

fun AppCompatActivity.inflateFragmentInView(
    view : View,
    fragment: BaseFragment
){
    supportFragmentManager.beginTransaction()
                          .replace(view.id, fragment)
                          .addToBackStack(null)
                          .commit()
}

fun FragmentData?.safeFragmentInstance(
    success : (FragmentData) -> Unit,
    error : (Exception) -> Unit
) {
    this?.id?.let { success(this) }  ?: error( Exception("FragmentId not found") )
}
