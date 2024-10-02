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

    // Function to add a history entry
    fun addHistoryEntry(weight: Float, height: Float, bmi: Float, category: String) {
        val currentHistory = _history.value ?: emptyList()
        val newEntry = HistoryEntry(weight, height, bmi, category)
        _history.value = currentHistory + newEntry

        // Log current history entries
        Log.d("HistoryViewModel", "History entries: ${_history.value}")
    }
}
