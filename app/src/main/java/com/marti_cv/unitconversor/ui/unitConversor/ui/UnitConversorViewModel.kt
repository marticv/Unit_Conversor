package com.marti_cv.unitconversor.ui.unitConversor.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UnitConversorViewModel @Inject constructor() :ViewModel() {

    private val _exposeFirstSpinner = MutableLiveData<Boolean>()
    var exposeFirstSpinner: LiveData<Boolean> = _exposeFirstSpinner

    private val _exposeSecondSpinner = MutableLiveData<Boolean>()
    var exposeSecondSpinner: LiveData<Boolean> = _exposeSecondSpinner

    private val _valueFirstText = MutableLiveData<String>()
    var valueFirstText: LiveData<String> = _valueFirstText

    private val _valueSecondText = MutableLiveData<String>()
    var valueSecondText: LiveData<String> = _valueSecondText

    fun changeFirstSpinnerExposedState(){
            _exposeFirstSpinner.value = !_exposeFirstSpinner.value!!

    }

    fun changeSecondSpinnerExposedState(){
            _exposeSecondSpinner.value = !_exposeSecondSpinner.value!!
    }

}