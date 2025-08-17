package lifescenario.com.data.manager

import kotlinx.coroutines.flow.Flow
import lifescenario.com.data.db.entity.CardEntity

interface CardGameRepositoryContract {
    fun getAllCards(): Flow<List<CardEntity>>
    fun getCardByPersonalId(id: Int): CardEntity?
    fun getNextCards(card: CardEntity, count: Int): List<CardEntity>
}
