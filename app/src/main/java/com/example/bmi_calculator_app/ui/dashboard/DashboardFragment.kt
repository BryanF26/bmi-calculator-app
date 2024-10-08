package com.example.bmi_calculator_app.ui.dashboard

import androidx.navigation.fragment.findNavController
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.bmi_calculator_app.R
import com.example.bmi_calculator_app.viewmodel.SharedViewModel

class DashboardFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    @SuppressLint("StringFormatInvalid")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val bmiTextView = rootView.findViewById<TextView>(R.id.bmi_result)
        val categoryTextView = rootView.findViewById<TextView>(R.id.bmi_category)
        val weightTextView = rootView.findViewById<TextView>(R.id.weight_result)
        val heightTextView = rootView.findViewById<TextView>(R.id.height_result)

        // Observing weight
        sharedViewModel.weight.observe(viewLifecycleOwner) { weight ->
            weightTextView.text = getString(R.string.weight_display, weight)
        }

        // Observing height
        sharedViewModel.height.observe(viewLifecycleOwner) { height ->
            heightTextView.text = getString(R.string.height_display, height)
        }

        // Observing BMI result
        sharedViewModel.bmiResult.observe(viewLifecycleOwner) { bmi ->
            bmiTextView.text = getString(R.string.bmi_display, bmi)
        }

        // Observing BMI category
        sharedViewModel.bmiCategory.observe(viewLifecycleOwner) { bmiCategory ->
            categoryTextView.text = getString(R.string.bmi_category_display, bmiCategory)
        }

        return rootView
    }

}
