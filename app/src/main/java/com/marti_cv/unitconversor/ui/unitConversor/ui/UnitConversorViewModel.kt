package com.marti_cv.unitconversor.ui.unitConversor.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
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

    init {
        _exposeFirstSpinner.value =false
        _exposeSecondSpinner.value = false
        _valueFirstText.value=""
        _valueSecondText.value="0"
    }

    fun onValueChange(value:String){
        _valueFirstText.value =value
    }
    fun onValueChange2(value:String){
        _valueSecondText.value =value
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

    fun onExchangeClicked(){
        if(_valueFirstText.value != null && _valueSecondText.value !=null){
            val firstValue = _valueFirstText.value
            val secondValue = _valueSecondText.value

            _valueFirstText.value =secondValue
            _valueSecondText.value = firstValue
        }
    }

}