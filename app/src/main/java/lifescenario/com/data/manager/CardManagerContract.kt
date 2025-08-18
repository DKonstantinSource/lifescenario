package lifescenario.com.data.manager


import kotlinx.coroutines.flow.StateFlow
import lifescenario.com.data.db.entity.CardEntity

interface CardManagerContract {

    fun startGame()
    fun selectCard(selectedCard: CardEntity)
    fun selectCards(cards: List<CardEntity>)
    fun getCurrentCard(): CardEntity?
    fun getCurrentCards(): List<CardEntity>
    fun isEndOfCareerOrMarriageBranch(): Boolean
}