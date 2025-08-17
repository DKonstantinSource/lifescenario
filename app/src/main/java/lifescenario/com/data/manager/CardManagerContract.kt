package lifescenario.com.data.manager


import kotlinx.coroutines.flow.StateFlow
import lifescenario.com.data.db.entity.CardEntity

interface CardManagerContract {

    val currentCards: StateFlow<List<CardEntity>>
    fun startGame()
    fun selectCard(selectedCard: CardEntity)
    fun getCurrentCard(): CardEntity?
}
