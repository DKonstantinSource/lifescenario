package lifescenario.com.data.manager

import lifescenario.com.data.db.entity.CardEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import lifescenario.com.data.manager.cards.WorkAfterUniversity
import lifescenario.com.data.manager.cards.WorkWithoutUniversity
import lifescenario.com.data.manager.cards.WorldEvents

class CardManager(
    private val repository: CardGameRepositoryContract
) : CardManagerContract {

    private val _currentCards = MutableStateFlow<List<CardEntity>>(emptyList())
    override val currentCards = _currentCards.asStateFlow()

    private var currentCard: CardEntity? = null

    override fun startGame() {
        val firstCard = repository.getCardByPersonalId(1) ?: return
        currentCard = firstCard
        _currentCards.value = listOf(firstCard)
    }

    override fun selectCard(selectedCard: CardEntity) {
        currentCard = selectedCard

        val nextCards = when {
            selectedCard.cardPersonalId == 2 -> WorkAfterUniversity.cards.shuffled().take(2)
            selectedCard.cardPersonalId == 3 -> WorkWithoutUniversity.cards.shuffled().take(2)

            WorkAfterUniversity.cards.contains(selectedCard) ||
                    WorkWithoutUniversity.cards.contains(selectedCard) -> WorldEvents.getRandomEvents(10)

            else -> repository.getNextCards(selectedCard, 2)
        }

        _currentCards.value = nextCards
    }

    override fun getCurrentCard(): CardEntity? = currentCard
}
