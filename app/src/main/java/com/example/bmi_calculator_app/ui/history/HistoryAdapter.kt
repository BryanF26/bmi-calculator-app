package com.example.bmi_calculator_app.ui.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bmi_calculator_app.R

class HistoryAdapter(private val historyList: List<CurrencyRateHistory>) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    class HistoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val currencyText: TextView = view.findViewById(R.id.tvCurrency)
        val dateText: TextView = view.findViewById(R.id.tvDate)
        val rateText: TextView = view.findViewById(R.id.tvRate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_currency_history, parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val history = historyList[position]
        holder.currencyText.text = history.currency
        holder.dateText.text = history.date
        holder.rateText.text = history.rate.toString()
    }

    override fun getItemCount(): Int = historyList.size
}

