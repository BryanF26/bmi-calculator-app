package com.example.bmi_calculator_app.ui.home

import androidx.navigation.fragment.findNavController
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.bmi_calculator_app.R
import com.example.bmi_calculator_app.ui.dashboard.DashboardFragment
import com.example.bmi_calculator_app.ui.dashboard.HistoryViewModel
import com.example.bmi_calculator_app.viewmodel.SharedViewModel
import kotlin.math.pow

class HomeFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val historyViewModel: HistoryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        val weightInput = rootView.findViewById<EditText>(R.id.weight)
        val heightInput = rootView.findViewById<EditText>(R.id.height)
        val calculateButton = rootView.findViewById<Button>(R.id.btn_calculate)
        val resultTextView = rootView.findViewById<TextView>(R.id.result)

        calculateButton.setOnClickListener {
            val weight = weightInput.text.toString().toDoubleOrNull()
            val height = heightInput.text.toString().toDoubleOrNull()

            if (weight != null && height != null && height > 0) {
                sharedViewModel.setWeight(weight)
                sharedViewModel.setHeight(height)

                val bmi = calculateBMI(weight, height)
                sharedViewModel.setBmiResult(bmi)

                val bmiCategory = getBMICategory(bmi)
                sharedViewModel.setBmiCategory(bmiCategory)
                addHistoryEntry(bmi)

                weightInput.setText("")
                heightInput.setText("")

                Toast.makeText(requireContext(), "Calculate Successfully!", Toast.LENGTH_SHORT).show()
                resultTextView.text = getString(R.string.bmi_result, bmi, bmiCategory)

                findNavController().navigate(R.id.navigation_dashboard)

            } else {
                resultTextView.text = getString(R.string.invalid_input)
            }
        }

        return rootView
    }

    private fun calculateBMI(weight: Double, height: Double): Double {
        return weight / height.pow(2)
    }

    private fun getBMICategory(bmi: Double): String {
        return when {
            bmi < 18.5 -> "Underweight"
            bmi in 18.5..24.9 -> "Normal weight"
            bmi in 25.0..29.9 -> "Overweight"
            else -> "Obese"
        }
    }

    private fun addHistoryEntry(bmi: Double) {
        val weight = sharedViewModel.weight.value ?: 0.0
        val height = sharedViewModel.height.value ?: 0.0
        historyViewModel.addHistoryEntry(weight.toFloat(), height.toFloat(), bmi.toFloat(), sharedViewModel.bmiCategory.value ?: "Unknown")
    }
}
