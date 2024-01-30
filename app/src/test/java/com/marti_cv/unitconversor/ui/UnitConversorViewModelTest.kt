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
    fun test() {
        assert(unitConversorViewModel.valueFirstText.value=="")
    }
}