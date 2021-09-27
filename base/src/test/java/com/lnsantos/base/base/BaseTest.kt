package com.lnsantos.base.base

import io.mockk.MockKAnnotations
import io.mockk.unmockkAll
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Before

abstract class BaseTest {

    abstract fun onStart()

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        onStart()
    }

    @After
    fun onDestroy(){
        unmockkAll()
    }

    fun isTrue() = Matchers.equalTo(true)
    fun isFalse() = Matchers.equalTo(false)
}