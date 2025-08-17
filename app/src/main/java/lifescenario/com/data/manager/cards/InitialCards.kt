package lifescenario.com.data.manager.cards

import lifescenario.com.data.db.entity.CardEntity
import lifescenario.com.data.db.entity.CardType
import lifescenario.com.data.db.entity.stat.PersonalStat.*

object InitialCards {

    val cards = listOf(
        CardEntity(
            cardPersonalId = 1,
            title = "Начало пути",
            description = "Вы окончили школу. Что дальше?",
            type = CardType.STATS,
            statEffect = mapOf(EDUCATION to 1),
            nextCardPersonalIds = listOf(2, 3),
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 2,
            title = "Поступить в университет",
            description = "Вы решили пойти учиться дальше.",
            type = CardType.EDUCATION,
            statEffect = mapOf(EDUCATION to 2),
            nextCardPersonalIds = WorkAfterUniversity.cards.map { it.cardPersonalId },
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 3,
            title = "Сразу работать",
            description = "Решаете заработать денег.",
            type = CardType.JOB,
            statEffect = mapOf(RICHES to 1),
            nextCardPersonalIds = WorkWithoutUniversity.cards.map { it.cardPersonalId },
            backgroundImage = "image_university.jpg"
        )



    )

    fun getCardByPersonalId(id: Int): CardEntity? {
        val allCards = cards + WorkWithoutUniversity.cards + WorkAfterUniversity.cards
        return allCards.find { it.cardPersonalId == id }
    }

    fun getRandomNextCard(card: CardEntity): CardEntity? {
        return card.nextCardPersonalIds.randomOrNull()?.let { getCardByPersonalId(it) }
    }

    fun getRandomNextCards(card: CardEntity, count: Int): List<CardEntity> {
        return card.nextCardPersonalIds
            .shuffled()
            .take(count)
            .mapNotNull { getCardByPersonalId(it) }
    }
}
