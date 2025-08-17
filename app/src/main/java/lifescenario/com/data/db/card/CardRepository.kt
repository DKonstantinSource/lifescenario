package lifescenario.com.data.db.card

import kotlinx.coroutines.flow.Flow
import lifescenario.com.data.db.dao.CardDao
import lifescenario.com.data.db.entity.CardEntity

class CardRepository(private val dao: CardDao) : CardRepositoryContract {

    override fun getCards(): Flow<List<CardEntity>> = dao.getAllCards()

    override suspend fun insertCard(card: CardEntity) = dao.insert(card)

    override suspend fun clearCards() = dao.clearCards()

    override suspend fun insertInitialCards(initialCards: List<CardEntity>) {
        clearCards()
        initialCards.forEach { insertCard(it) }
    }
}
