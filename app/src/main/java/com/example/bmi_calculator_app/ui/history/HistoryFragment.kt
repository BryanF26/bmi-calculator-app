package com.example.bmi_calculator_app.ui.history

import HistoryAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bmi_calculator_app.R
import com.example.bmi_calculator_app.ui.dashboard.HistoryViewModel

class HistoryFragment : Fragment() {

    private val historyViewModel: HistoryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.history_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = HistoryAdapter()
        recyclerView.adapter = adapter

        historyViewModel.history.observe(viewLifecycleOwner) { history ->
            Log.d("HistoryFragment", "History size: ${history.size}") // Log the size of the history list
            adapter.submitList(history)
        }
    }


}
