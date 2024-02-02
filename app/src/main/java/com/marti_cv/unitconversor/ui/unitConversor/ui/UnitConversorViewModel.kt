package com.marti_cv.unitconversor.ui.unitConversor.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.math.BigDecimal
import java.math.RoundingMode
import javax.inject.Inject

@HiltViewModel
class UnitConversorViewModel @Inject constructor() : ViewModel() {

    private val _exposeFirstSpinner = MutableLiveData<Boolean>()
    var exposeFirstSpinner: LiveData<Boolean> = _exposeFirstSpinner

    private val _exposeSecondSpinner = MutableLiveData<Boolean>()
    var exposeSecondSpinner: LiveData<Boolean> = _exposeSecondSpinner

    private val _valueFirstText = MutableLiveData<String>()
    var valueFirstText: LiveData<String> = _valueFirstText

    private val _valueSecondText = MutableLiveData<String>()
    var valueSecondText: LiveData<String> = _valueSecondText

    private val _options = mutableStateListOf<String>(
        "Km2",
        "m2",
        "milla2",
        "Yarda2",
        "pie2",
        "pulgada2",
        "hectarea",
        "Acre"
    )
    val options: List<String> = _options

    private val _selectedOptionsText = MutableLiveData<String>()
    private val _selectedOptionsIndex = MutableLiveData<Int>()
    var selectedOptionText: LiveData<String> = _selectedOptionsText

    private val _selectedOptionsText2 = MutableLiveData<String>()
    private val _selectedOptionsIndex2 = MutableLiveData<Int>()
    var selectedOptionText2: LiveData<String> = _selectedOptionsText2


    init {
        _exposeFirstSpinner.value = false
        _exposeSecondSpinner.value = false
        _valueFirstText.value = ""
        _valueSecondText.value = "0"
        _selectedOptionsIndex.value = 0
        _selectedOptionsText.value = _options[0]
        _selectedOptionsIndex2.value = 0
        _selectedOptionsText2.value = _options[0]
    }

    fun onSelectedItemChanged(item: String) {
        when (item) {
            "Km2" -> {
                _selectedOptionsIndex.value = 0
                _selectedOptionsText.value = _options[0]
            }

            "m2" -> {
                _selectedOptionsIndex.value = 1
                _selectedOptionsText.value = _options[1]
            }

            "milla2" -> {
                _selectedOptionsIndex.value = 2
                _selectedOptionsText.value = _options[2]
            }

            "Yarda2" -> {
                _selectedOptionsIndex.value = 3
                _selectedOptionsText.value = _options[3]
            }

            "pie2" -> {
                _selectedOptionsIndex.value = 4
                _selectedOptionsText.value = _options[4]
            }

            "pulgada2" -> {
                _selectedOptionsIndex.value = 5
                _selectedOptionsText.value = _options[5]
            }

            "hectarea" -> {
                _selectedOptionsIndex.value = 6
                _selectedOptionsText.value = _options[6]
            }

            "Acre" -> {
                _selectedOptionsIndex.value = 7
                _selectedOptionsText.value = _options[7]
            }
        }
        changeValue()
    }

    fun onSelectedItemChanged2(item: String) {
        when (item) {
            "Km2" -> {
                _selectedOptionsIndex2.value = 0
                _selectedOptionsText2.value = _options[0]
            }

            "m2" -> {
                _selectedOptionsIndex2.value = 1
                _selectedOptionsText2.value = _options[1]
            }

            "milla2" -> {
                _selectedOptionsIndex2.value = 2
                _selectedOptionsText2.value = _options[2]
            }

            "Yarda2" -> {
                _selectedOptionsIndex2.value = 3
                _selectedOptionsText2.value = _options[3]
            }

            "pie2" -> {
                _selectedOptionsIndex2.value = 4
                _selectedOptionsText2.value = _options[4]
            }

            "pulgada2" -> {
                _selectedOptionsIndex2.value = 5
                _selectedOptionsText2.value = _options[5]
            }

            "hectarea" -> {
                _selectedOptionsIndex2.value = 6
                _selectedOptionsText2.value = _options[6]
            }

            "Acre" -> {
                _selectedOptionsIndex2.value = 7
                _selectedOptionsText2.value = _options[7]
            }
        }
        changeValue()
    }

    fun onValueChange(value: String) {
        if(checkValueIsDouble(value)){
            _valueFirstText.value = value
            changeValue()
        }
    }

    fun onValueChange2(value: String) {
        changeValue()
    }

    fun changeFirstSpinnerExposedState() {
        if (_exposeFirstSpinner.value != null) {
            _exposeFirstSpinner.value = !_exposeFirstSpinner.value!!
        } else {
            _exposeFirstSpinner.value = false
        }
    }

    fun onCloseFirstSpinner() {
        _exposeFirstSpinner.value = false
    }

    fun changeSecondSpinnerExposedState() {
        if (exposeSecondSpinner.value != null) {
            _exposeSecondSpinner.value = !_exposeSecondSpinner.value!!
        } else {
            _exposeSecondSpinner.value = false
        }
    }

    fun onCloseSecondSpinner() {
        _exposeSecondSpinner.value = false
    }

    fun onExchangeClicked() {
        if (_valueFirstText.value != null && _valueSecondText.value != null) {
            val firstValue = _valueFirstText.value
            val secondValue = _valueSecondText.value

            _valueFirstText.value = secondValue!!
            _valueSecondText.value = firstValue!!
        }
    }

    private fun changeValue() {
        if (_valueFirstText.value != "") {
            if (_selectedOptionsIndex.value == _selectedOptionsIndex2.value) {
                _valueSecondText.value = _valueFirstText.value
            } else {
                val systemConversions: Array<Double> =
                    arrayOf(1000000.0, 1.0, 2590000.0, 1.196, 10.764, 1500.0, 10000.0, 4047.0)
                var finalValue: Double =
                    (systemConversions[_selectedOptionsIndex.value!!] / systemConversions[_selectedOptionsIndex2.value!!])
                val userValue: Int = _valueFirstText.value!!.toInt()
                finalValue *= userValue
                changeResultTo2Decimals(finalValue)
            }
        }
    }

     private fun changeResultTo2Decimals(value:Double){
        val decimal: BigDecimal = BigDecimal(value).setScale(5, RoundingMode.HALF_EVEN)
        _valueSecondText.value =decimal.toString()
    }


    private fun checkValueIsDouble(value: String): Boolean {
        return try {
            value.toDouble()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }


}