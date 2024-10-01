package com.example.bmi_calculator_app.ui.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bmi_calculator_app.model.HistoryEntry

class HistoryViewModel : ViewModel() {
    // LiveData for history entries
    private val _history = MutableLiveData<List<HistoryEntry>>(emptyList())
    val history: LiveData<List<HistoryEntry>> get() = _history

    // LiveData for weight
    private val _weight = MutableLiveData<Double>()
    val weight: LiveData<Double> get() = _weight

    // LiveData for height
    private val _height = MutableLiveData<Double>()
    val height: LiveData<Double> get() = _height

    // LiveData for BMI result
    private val _bmiResult = MutableLiveData<Double>()
    val bmiResult: LiveData<Double> get() = _bmiResult

    // LiveData for BMI category
    private val _bmiCategory = MutableLiveData<String>()
    val bmiCategory: LiveData<String> get() = _bmiCategory

    // Setters for weight, height, BMI result, and category
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

    // Function to add a history entry
    fun addHistoryEntry(weight: Float, height: Float, bmi: Float, category: String) {
        val currentHistory = _history.value ?: emptyList()
        val newEntry = HistoryEntry(weight, height, bmi, category)
        _history.value = currentHistory + newEntry

        // Log current history entries
        Log.d("HistoryViewModel", "History entries: ${_history.value}") // Log the current history entries
    }
}
