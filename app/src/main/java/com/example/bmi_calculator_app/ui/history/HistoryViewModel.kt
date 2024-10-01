import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bmi_calculator_app.ui.history.CurrencyRateHistory

class HistoryViewModel : ViewModel() {

    private val _currencyRateHistory = MutableLiveData<List<CurrencyRateHistory>>()
    val currencyRateHistory: LiveData<List<CurrencyRateHistory>> get() = _currencyRateHistory

    init {
        // Load historical data for currency rates (could be from API, database, etc.)
        loadCurrencyRateHistory()
    }

    private fun loadCurrencyRateHistory() {
        // Simulated currency rate history data
        _currencyRateHistory.value = listOf(
            CurrencyRateHistory("USD", "2024-09-29", 1.0),
            CurrencyRateHistory("EUR", "2024-09-29", 0.85),
            CurrencyRateHistory("JPY", "2024-09-29", 110.0),
            CurrencyRateHistory("GBP", "2024-09-29", 0.75)
        )
    }
}
