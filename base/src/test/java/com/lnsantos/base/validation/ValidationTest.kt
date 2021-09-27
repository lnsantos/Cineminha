package com.lnsantos.base.validation

import com.lnsantos.base.base.BaseTest
import com.lnsantos.base.resources.ValidationResource
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.Test
import java.lang.Exception


class ValidationTest : BaseTest() {


    private lateinit var validation : Validation

    override fun onStart() {
        validation = Validation()
    }

    @Test
    fun validateTypes(){
        MatcherAssert.assertThat(Validation.EMAIL, Matchers.equalTo(1))
    }

    @Test
    fun givenEmailValid_whenMethodHasCalled_thenReturnTrue(){

        // given
        val paramEmail = ValidationResource.FAKE_EMAIL_VALID
        val paramType = Validation.EMAIL

        // when
        val result = validation.validateString(paramEmail)
                               .build(paramType)

        // then
        MatcherAssert.assertThat(result, isTrue())
    }

    @Test
    fun givenEmailNotValid_whenMethodHasCalled_thenReturnFalse() {

        // given
        val paramEmail = ValidationResource.FAKE_EMAIL_NOT_VALID
        val paramType = Validation.EMAIL

        // when
        val result = validation.validateString(paramEmail)
                               .build(paramType)

        // then
        MatcherAssert.assertThat(result, isFalse())
    }

    @Test
    fun givenPassEmptyEmail_whenMethodHasCalled_thenReturnThrow() {

        // given
        val paramEmail = ValidationResource.FAKE_EMAIL_EMPTY
        val paramType = Validation.EMAIL

        // when
        val validate =  try {
            validation.validateString(paramEmail)
                      .build(paramType)
        } catch (e: Exception){ e }

        // then
        MatcherAssert.assertThat(validate, Matchers.instanceOf(Exception::class.java))
    }

    @Test
    fun givenPassNullEmail_whenMethodHasCalled_thenReturnThrow() {

        // given
        val paramEmail = null
        val paramType = Validation.EMAIL

        // when
        val validate =  try {
            validation.validateString(paramEmail)
                      .build(paramType)
        } catch (e: Exception){ e }

        // then
        MatcherAssert.assertThat(validate, Matchers.instanceOf(Exception::class.java))
    }

    @Test
    fun givenInvalidType_whenMethodHasCalled_thenReturnThrow() {

        // given
        val paramEmail = ValidationResource.FAKE_EMAIL_VALID
        val paramType = ValidationResource.FAKE_TYPE_INVALID

        // when
        val validate =  try {
            validation.validateString(paramEmail).build(paramType)
        } catch (e: Exception){ e }

        // then
        MatcherAssert.assertThat(validate, Matchers.instanceOf(Exception::class.java))
    }

}