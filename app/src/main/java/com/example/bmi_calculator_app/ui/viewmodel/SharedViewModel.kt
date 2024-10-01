package com.example.bmi_calculator_app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val _weight = MutableLiveData<Double>()
    val weight: LiveData<Double> get() = _weight

    private val _height = MutableLiveData<Double>()
    val height: LiveData<Double> get() = _height

    private val _bmiResult = MutableLiveData<Double>()
    val bmiResult: LiveData<Double> get() = _bmiResult

    private val _bmiCategory = MutableLiveData<String>()
    val bmiCategory: LiveData<String> get() = _bmiCategory

    fun setWeight(weight: Double) {
        _weight.value = weight
    }

    fun setHeight(height: Double) {
        _height.value = height
    }

    fun setBmiResult(bmi: Double) {
        _bmiResult.value = bmi
    }

    fun setBmiCategory(category: String) {
        _bmiCategory.value = category
    }
}
