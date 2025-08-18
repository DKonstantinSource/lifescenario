package lifescenario.com.data.manager

import lifescenario.com.data.db.entity.CardEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import lifescenario.com.data.db.entity.CardType
import lifescenario.com.data.manager.cards.InitialCards
import lifescenario.com.data.manager.cards.youth.WorkAfterUniversity
import lifescenario.com.data.manager.cards.youth.WorkWithoutUniversity
import lifescenario.com.data.manager.cards.WorldEvents


class CardManager(
    private val repository: CardGameRepositoryContract
) : CardManagerContract {

    private val _currentCards = MutableStateFlow<List<CardEntity>>(emptyList())
    val currentCards = _currentCards.asStateFlow()

    private var currentCard: CardEntity? = null
    private var worldEventsQueue: MutableList<CardEntity> = mutableListOf()
    private var worldEventCounter = 0
    private val maxWorldEvents = 10
    private var lastWorldEventCardId: Int? = null


    override fun startGame() {
        val firstCard = repository.getCardByPersonalId(1) ?: return
        currentCard = firstCard
        _currentCards.value = listOf(firstCard)
        worldEventCounter = 0
        worldEventsQueue.clear()
    }

    override fun selectCard(selectedCard: CardEntity) {
        currentCard = selectedCard

        val nextCards: List<CardEntity> = when {
            selectedCard.cardPersonalId == 2 -> WorkAfterUniversity.cards.shuffled().take(2)
            selectedCard.cardPersonalId == 3 -> WorkWithoutUniversity.cards.shuffled().take(2)

            (WorkAfterUniversity.cards.contains(selectedCard) || WorkWithoutUniversity.cards.contains(selectedCard)) &&
                    worldEventCounter == 0 -> {
                worldEventsQueue = WorldEvents.getRandomEvents(maxWorldEvents).toMutableList()
                takeNextWorldEvents()
            }

            worldEventCounter in 1 until maxWorldEvents -> takeNextWorldEvents()

            // Завершение всех мировых событий — показываем карту 300
            worldEventCounter >= maxWorldEvents && worldEventsQueue.isEmpty() &&
                    selectedCard.cardPersonalId != 300 -> {
                listOfNotNull(InitialCards.getCardByPersonalId(300))
            }

            // Если нажали на карту 300 — показываем выбор 301/302
            selectedCard.cardPersonalId == 300 -> {
                listOfNotNull(
                    InitialCards.getCardByPersonalId(301),
                    InitialCards.getCardByPersonalId(302)
                )
            }

            else -> repository.getNextCards(selectedCard, 2)
        }

        _currentCards.value = nextCards
    }




    private fun takeNextWorldEvents(): List<CardEntity> {
        val count = minOf(2, worldEventsQueue.size)

        if (count > 0) {
            lastWorldEventCardId = worldEventsQueue.lastOrNull()?.cardPersonalId
        }

        worldEventCounter += count
        return if (count > 0) {
            List(count) { worldEventsQueue.removeAt(0) }
        } else {
            listOfNotNull(InitialCards.getCardByPersonalId(300))
        }
    }



    override fun selectCards(cards: List<CardEntity>) {
        if (cards.isNotEmpty()) {
            currentCard = cards.first()
            _currentCards.value = cards
        }
    }

    override fun getCurrentCard(): CardEntity? = currentCard

    override fun getCurrentCards(): List<CardEntity> = _currentCards.value
}
