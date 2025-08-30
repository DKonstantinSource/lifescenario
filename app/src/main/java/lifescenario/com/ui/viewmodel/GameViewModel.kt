package lifescenario.com.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import lifescenario.com.data.db.entity.CardEntity
import lifescenario.com.data.db.entity.stat.PersonalStat
import lifescenario.com.data.manager.CardManagerContract
import lifescenario.com.data.manager.cards.home.CardHomeBuying

class GameViewModel(
    private val cardManager: CardManagerContract,
    private val economyViewModel : FinanceViewModel
) : ViewModel() {

    private val _health = MutableStateFlow(0)
    val health: StateFlow<Int> = _health

    private val _riches = MutableStateFlow(0)
    val riches: StateFlow<Int> = _riches

    private val _education = MutableStateFlow(0)
    val education: StateFlow<Int> = _education

    private val _currentCards = MutableStateFlow<List<CardEntity>>(emptyList())
    val currentCards: StateFlow<List<CardEntity>> = _currentCards

    private val _isIntroVisible = MutableStateFlow(true)
    val isIntroVisible: StateFlow<Boolean> = _isIntroVisible

    private val _showInsufficientStatOverlay = MutableStateFlow<Map<PersonalStat, Int>>(emptyMap())
    val showInsufficientStatOverlay: StateFlow<Map<PersonalStat, Int>> = _showInsufficientStatOverlay


    private val _showHomeBuyingOverlay = MutableStateFlow(false)
    val showHomeBuyingOverlay: StateFlow<Boolean> = _showHomeBuyingOverlay


    private val _cardPending = MutableStateFlow<CardEntity?>(null)

    val statPurchaseCost = 500

    private var worldEventsQueue: MutableList<CardEntity> = mutableListOf()



    val money: StateFlow<Int> = economyViewModel.money

    fun applyRewardStatsFromAd(missingStats: Map<PersonalStat, Int>) {
        missingStats.forEach { (stat, value) -> increaseStat(stat, value) }
        _showInsufficientStatOverlay.value = emptyMap()
        _cardPending.value?.let { applyCardEffect(it) }
        _cardPending.value = null
    }


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
        val missingStatsMap = card.statEffect.entries
            .filter { (stat, value) -> value < 0 && getStatValue(stat) + value < 0 }
            .associate { (stat, value) ->
                val needed = -(getStatValue(stat) + value)
                stat to needed
            }

        if (missingStatsMap.isNotEmpty()) {
            _showInsufficientStatOverlay.value = missingStatsMap
            _cardPending.value = card
        } else {
            applyCardEffect(card)
        }
    }

    fun buyStatViaMoney() {
        val card = _cardPending.value ?: return
        val statsMap = _showInsufficientStatOverlay.value
        if (statsMap.isEmpty()) return

        val totalCost = statsMap.values.sum() * statPurchaseCost
        if (economyViewModel.money.value >= totalCost) {
            economyViewModel.applyCustomChange(-totalCost, "покупка статов")
            statsMap.forEach { (stat, count) -> increaseStat(stat, count) }
            _showInsufficientStatOverlay.value = emptyMap()
            _cardPending.value = null
            selectCard(card)
        }
    }


    fun cancelStatPurchase() {
        _showInsufficientStatOverlay.value = emptyMap()
        _cardPending.value = null
    }

    private fun applyCardEffect(card: CardEntity) {
        viewModelScope.launch {
            card.statEffect.forEach { (stat, value) ->
                when (stat) {
                    PersonalStat.HEALTH -> _health.value += value
                    PersonalStat.RICHES -> _riches.value += value
                    PersonalStat.EDUCATION -> _education.value += value
                    PersonalStat.MONEY -> economyViewModel.applyCustomChange(value, "карта")
                }
            }

            card.salary?.let { economyViewModel.applySalary(it) }
            card.tax?.let { economyViewModel.applyTax(it) }

            cardManager.selectCard(card)
            _currentCards.value = cardManager.getCurrentCards()

            if (cardManager.isEndOfCareerOrMarriageBranch() && !_showHomeBuyingOverlay.value) {
                _showHomeBuyingOverlay.value = true
            }
        }
    }


    fun hideHomeBuyingOverlay() {
        _showHomeBuyingOverlay.value = false
        loadHomeBuyingCards()
    }

    fun loadHomeBuyingCards() {
        _currentCards.value = CardHomeBuying.cards.shuffled().take(2)
    }




    private fun getStatValue(stat: PersonalStat): Int = when (stat) {
        PersonalStat.HEALTH -> _health.value
        PersonalStat.RICHES -> _riches.value
        PersonalStat.EDUCATION -> _education.value
        PersonalStat.MONEY -> economyViewModel.money.value
    }

    private fun increaseStat(stat: PersonalStat, value: Int) = when (stat) {
        PersonalStat.HEALTH -> _health.value += value
        PersonalStat.RICHES -> _riches.value += value
        PersonalStat.EDUCATION -> _education.value += value
        PersonalStat.MONEY -> economyViewModel.applyCustomChange(value, "ручное повышение")
    }
}
