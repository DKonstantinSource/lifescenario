package lifescenario.com.data.manager

import android.util.Log
import lifescenario.com.data.db.entity.CardEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import lifescenario.com.data.db.entity.CardType
import lifescenario.com.data.manager.cards.InitialCards
import lifescenario.com.data.manager.cards.youth.WorkAfterUniversity
import lifescenario.com.data.manager.cards.youth.WorkWithoutUniversity
import lifescenario.com.data.manager.cards.WorldEvents
import lifescenario.com.data.manager.cards.twostage.CardAfterCareer
import lifescenario.com.data.manager.cards.twostage.CardAfterMarried


class CardManager(
    private val repository: CardGameRepositoryContract
) : CardManagerContract {

    private val _currentCards = MutableStateFlow<List<CardEntity>>(emptyList())
    val currentCards = _currentCards.asStateFlow()

    private var currentCard: CardEntity? = null
    private var worldEventsQueue: MutableList<CardEntity> = mutableListOf()
    private var worldEventCounter = 0
    private var secondWorldEventWaveStarted = false
    private var lastWorldEventCardId: Int? = null

    private val totalWorldEvents = 16

    override fun startGame() {
        val firstCard = repository.getCardByPersonalId(1) ?: return
        currentCard = firstCard
        _currentCards.value = listOf(firstCard)
        worldEventCounter = 0
        worldEventsQueue.clear()
        secondWorldEventWaveStarted = false
    }

    override fun selectCard(selectedCard: CardEntity) {
        currentCard = selectedCard

        val nextCards: List<CardEntity> = when {
            selectedCard.cardPersonalId == 2 -> WorkAfterUniversity.cards.shuffled().take(2)
            selectedCard.cardPersonalId == 3 -> WorkWithoutUniversity.cards.shuffled().take(2)

            selectedCard.cardPersonalId == 301 -> CardAfterMarried.cards.shuffled().take(2)
            selectedCard.cardPersonalId == 302 -> CardAfterCareer.cards.shuffled().take(2)

            (WorkAfterUniversity.cards.contains(selectedCard) || WorkWithoutUniversity.cards.contains(selectedCard)) &&
                    worldEventCounter < 10 -> {
                if (worldEventCounter == 0) {
                    worldEventsQueue = WorldEvents.getRandomEvents(10).toMutableList()
                }
                takeNextWorldEvents()
            }

            worldEventCounter in 1 until 10 -> takeNextWorldEvents()

            worldEventCounter >= 10 && selectedCard.cardPersonalId !in 300..302 -> {
                listOfNotNull(InitialCards.getCardByPersonalId(300))
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
            repository.getNextCards(currentCard ?: return emptyList(), 2)
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
