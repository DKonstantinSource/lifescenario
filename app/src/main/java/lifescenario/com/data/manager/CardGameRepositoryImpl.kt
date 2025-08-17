package lifescenario.com.data.manager

import kotlinx.coroutines.flow.Flow
import lifescenario.com.data.db.entity.CardEntity
import lifescenario.com.data.manager.cards.InitialCards
import lifescenario.com.data.manager.cards.WorkAfterUniversity
import lifescenario.com.data.manager.cards.WorkWithoutUniversity

class CardGameRepositoryImpl : CardGameRepositoryContract {

    private val allCards: List<CardEntity> =
        InitialCards.cards + WorkWithoutUniversity.cards + WorkAfterUniversity.cards

    override fun getAllCards(): Flow<List<CardEntity>> {
        return kotlinx.coroutines.flow.flow {
            emit(allCards)
        }
    }

    override fun getCardByPersonalId(id: Int): CardEntity? {
        return allCards.find { it.cardPersonalId == id }
    }

    override fun getNextCards(card: CardEntity, count: Int): List<CardEntity> {
        return card.nextCardPersonalIds
            .shuffled()
            .take(count)
            .mapNotNull { getCardByPersonalId(it) }
    }
}
