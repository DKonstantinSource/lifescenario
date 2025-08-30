package lifescenario.com.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import lifescenario.com.data.db.entity.CardEntity

class FinanceViewModel : ViewModel() {

    private val _money = MutableStateFlow(2000)
    val money: StateFlow<Int> = _money

    private val _transactions = MutableStateFlow<List<String>>(emptyList())
    val transactions: StateFlow<List<String>> = _transactions

    fun applySalary(amount: Int) {
        _money.value += amount
        addTransaction("+$amount зарплата")
    }

    fun applyTax(amount: Int) {
        _money.value -= amount
        addTransaction("-$amount налог")
    }

    fun applyCustomChange(amount: Int, reason: String) {
        _money.value += amount
        addTransaction("${if (amount >= 0) "+" else ""}$amount $reason")
    }

    private fun addTransaction(description: String) {
        _transactions.value = _transactions.value + description
    }
}
