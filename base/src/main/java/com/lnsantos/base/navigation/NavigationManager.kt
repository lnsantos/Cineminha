package com.lnsantos.base.navigation

import com.lnsantos.base.navigation.exception.NavigationManagerException
import com.lnsantos.base.navigation.model.FragmentData
import com.lnsantos.base.navigation.model.FragmentId

object NavigationManager {

    private var currentFragment : FragmentId = FragmentId.SIGN_IN
    private var previousFragment : FragmentId = FragmentId.SIGN_IN
    private var history : ArrayList<FragmentData> = arrayListOf()

    private var callback : NavigationListener? = null

    fun onCreate(){

        check(callback != null){
            throw NavigationManagerException("NavigationListener not be implemented")
        }

        history.takeIf { it.isNotEmpty() }?.first()?.let { data ->
            addFragment(data)
        }
    }

    fun onNavigationConnection(_callback : NavigationListener){
        this.callback = _callback
    }

    fun addFragment(newFragment : FragmentData){
        previousFragment = currentFragment
        currentFragment = newFragment.id

        history.add(newFragment)

        val findFragment = history.filter { it.id == currentFragment }
                                  .takeIf { it.isNotEmpty() }
                                  ?.run { first() }


        callback?.onNextFragment(findFragment)

    }

    fun onClean(){
        history.clear()
        addFragment(FragmentData(FragmentId.SIGN_IN))
    }

    fun onBackFragment(){

        if (isSingleOnlyScreen()){
            return
        }

        if (!canBackOneScreen()){
            return
        }

        val findFragment = history.filter { it.id == currentFragment }
                                  .takeIf { it.isNotEmpty() }
                                  ?.run { first() }


        callback?.onBackFragment(findFragment)

    }

    private fun isSingleOnlyScreen() : Boolean {
        val isSingleOnlyScreen = history.size == 1
        if (isSingleOnlyScreen){
            currentFragment = history.first().id
            previousFragment = FragmentId.NONE
        }

        return isSingleOnlyScreen
    }

    private fun canBackOneScreen() : Boolean {
        val canBackOneScreen = history.size > 1

        if (canBackOneScreen){
            history.removeLast()

            if (isSingleOnlyScreen()){
                return true
            }

            val lastOldPosition = history.lastIndex - 1

            currentFragment = history.last().id
            previousFragment = history[lastOldPosition].id
        }

        return canBackOneScreen
    }

}