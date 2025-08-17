package lifescenario.com.data.db.card

import kotlinx.coroutines.flow.Flow
import lifescenario.com.data.db.entity.CardEntity

interface CardRepositoryContract {
    fun getCards(): Flow<List<CardEntity>>
    suspend fun insertCard(card: CardEntity)
    suspend fun clearCards()
    suspend fun insertInitialCards(initialCards: List<CardEntity>)
}
