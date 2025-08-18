package lifescenario.com.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import lifescenario.com.data.db.entity.CardEntity
import lifescenario.com.data.db.entity.stat.PersonalStat
import lifescenario.com.data.manager.CardManagerContract

class GameViewModel(
    private val cardManager: CardManagerContract
) : ViewModel() {

    private val _health = MutableStateFlow(0)
    val health: StateFlow<Int> = _health

    private val _riches = MutableStateFlow(0)
    val riches: StateFlow<Int> = _riches

    private val _education = MutableStateFlow(0)
    val education: StateFlow<Int> = _education

    private val _money = MutableStateFlow(2000)
    val money: StateFlow<Int> = _money

    private val _currentCards = MutableStateFlow<List<CardEntity>>(emptyList())
    val currentCards: StateFlow<List<CardEntity>> = _currentCards

    private val _isIntroVisible = MutableStateFlow(true)
    val isIntroVisible: StateFlow<Boolean> = _isIntroVisible

    private val _showInsufficientStatOverlay = MutableStateFlow<PersonalStat?>(null)
    val showInsufficientStatOverlay: StateFlow<PersonalStat?> = _showInsufficientStatOverlay

    private val _cardPending = MutableStateFlow<CardEntity?>(null)

    val statPurchaseCost = 500

    private var worldEventsQueue: MutableList<CardEntity> = mutableListOf()

    fun hideIntroAndStartGame() {
        _isIntroVisible.value = false
        cardManager.startGame()
        _currentCards.value = cardManager.getCurrentCards()
        worldEventsQueue.clear()
    }

    fun resetIntro() {
        _isIntroVisible.value = true
    }

    fun selectCard(card: CardEntity) {
        val insufficientStat = card.statEffect.entries.firstOrNull { (stat, value) ->
            value < 0 && getStatValue(stat) + value < 0
        }

        if (insufficientStat != null) {
            _showInsufficientStatOverlay.value = insufficientStat.key
            _cardPending.value = card
        } else {
            applyCardEffect(card)
        }
    }

    fun buyStatToApplyPendingCard() {
        val card = _cardPending.value ?: return
        val stat = _showInsufficientStatOverlay.value ?: return

        if (_money.value >= statPurchaseCost) {
            _money.value -= statPurchaseCost
            increaseStat(stat, 1)
            _showInsufficientStatOverlay.value = null
            _cardPending.value = null
            selectCard(card)
        }
    }

    fun cancelStatPurchase() {
        _showInsufficientStatOverlay.value = null
        _cardPending.value = null
    }

    private fun applyCardEffect(card: CardEntity) {
        viewModelScope.launch {
            if (card.cardPersonalId != 300) {
                card.statEffect.forEach { (stat, value) ->
                    when (stat) {
                        PersonalStat.HEALTH -> _health.value += value
                        PersonalStat.RICHES -> _riches.value += value
                        PersonalStat.EDUCATION -> _education.value += value
                        PersonalStat.MONEY -> _money.value += value
                    }
                }
            }

            cardManager.selectCard(card)
            _currentCards.value = cardManager.getCurrentCards()
        }
    }


    private fun getStatValue(stat: PersonalStat): Int = when (stat) {
        PersonalStat.HEALTH -> _health.value
        PersonalStat.RICHES -> _riches.value
        PersonalStat.EDUCATION -> _education.value
        PersonalStat.MONEY -> _money.value
    }

    private fun increaseStat(stat: PersonalStat, value: Int) = when (stat) {
        PersonalStat.HEALTH -> _health.value += value
        PersonalStat.RICHES -> _riches.value += value
        PersonalStat.EDUCATION -> _education.value += value
        PersonalStat.MONEY -> _money.value += value
    }
}
