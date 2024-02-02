package com.marti_cv.unitconversor.ui

import androidx.test.runner.AndroidJUnit4
import com.marti_cv.unitconversor.ui.unitConversor.ui.UnitConversorViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config


@HiltAndroidTest
@Config(application=HiltTestApplication::class)
@RunWith(AndroidJUnit4::class)
class UnitConversorViewModelTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    private lateinit var unitConversorViewModel: UnitConversorViewModel

    @Before
    fun init() {
        hiltRule.inject()
        unitConversorViewModel = UnitConversorViewModel()
    }

    @Test
    fun `test initial values are correct`() {
        assert(unitConversorViewModel.exposeFirstSpinner.value == false)
        assert(unitConversorViewModel.exposeSecondSpinner.value == false)
        assert(unitConversorViewModel.valueFirstText.value == "")
        assert(unitConversorViewModel.valueSecondText.value == "0")
        assert(unitConversorViewModel.selectedOptionText.value == "Km2")
        assert(unitConversorViewModel.selectedOptionText2.value == "Km2")
    }

    @Test
    fun `test onValueChange1`() {
        unitConversorViewModel.onValueChange("10")
        assert(unitConversorViewModel.valueFirstText.value == "10")
    }

    @Test
    fun `test if value is not a number text does not change`() {
        val initialString = unitConversorViewModel.valueFirstText.value
        unitConversorViewModel.onValueChange("a")
        assert(unitConversorViewModel.valueFirstText.value == initialString)
    }

    @Test
    fun `test if value is a number text changes`() {
        unitConversorViewModel.onValueChange("10")
        assert(unitConversorViewModel.valueFirstText.value == "10")
    }

    @Test
    fun `test when correct value is entered _valueSecondText changes`() {
        var result =""
        unitConversorViewModel.onValueChange("10")
        result = unitConversorViewModel.valueSecondText.value!!
        assert(result == "10")
    }

    @Test
    fun `test the values is changed correctely after transformation`(){
        unitConversorViewModel.onSelectedItemChanged2("m2")
        unitConversorViewModel.onValueChange("1")
        val result = unitConversorViewModel.valueSecondText.value
        assert(result=="1000000.00000")
    }

    @Test
    fun `test when changeFirstSpinnerExposedState is used _exposeFirstSpinner changes`() {
        val initialValue = unitConversorViewModel.exposeFirstSpinner.value
        unitConversorViewModel.changeFirstSpinnerExposedState()
        assert(unitConversorViewModel.exposeFirstSpinner.value != initialValue)
    }

}