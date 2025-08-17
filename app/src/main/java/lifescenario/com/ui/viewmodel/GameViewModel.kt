package lifescenario.com.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import lifescenario.com.data.db.entity.CardEntity
import lifescenario.com.data.manager.CardManagerContract

class GameViewModel(
    private val cardManager: CardManagerContract
) : ViewModel() {

    val currentCards: StateFlow<List<CardEntity>> = cardManager.currentCards

    private val _isIntroVisible = MutableStateFlow(true)
    val isIntroVisible: StateFlow<Boolean> = _isIntroVisible

    fun hideIntroAndStartGame() {
        _isIntroVisible.value = false
        cardManager.startGame()
    }

    fun selectCard(card: CardEntity) {
        viewModelScope.launch {
            cardManager.selectCard(card)
        }
    }
}
