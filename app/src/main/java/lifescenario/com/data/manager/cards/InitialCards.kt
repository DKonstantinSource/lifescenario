package lifescenario.com.data.manager.cards

import lifescenario.com.data.db.entity.CardEntity
import lifescenario.com.data.db.entity.CardType
import lifescenario.com.data.db.entity.stat.PersonalStat.*
import lifescenario.com.data.manager.cards.mature.MatureCardHobbie
import lifescenario.com.data.manager.cards.mature.MatureCardRest
import lifescenario.com.data.manager.cards.twostage.CardAfterMarried
import lifescenario.com.data.manager.cards.twostage.CardAfterCareer
import lifescenario.com.data.manager.cards.youth.WorkAfterUniversity
import lifescenario.com.data.manager.cards.youth.WorkWithoutUniversity

object InitialCards {

    val cards = listOf(
        CardEntity(
            cardPersonalId = 1,
            title = "Начало пути",
            description = "Вы окончили школу. Что дальше?",
            type = CardType.STATS,
            statEffect = mapOf(EDUCATION to 1),
            nextCardPersonalIds = listOf(2, 3),
            backgroundImage = "image_school_end.jpg"
        ),
        CardEntity(
            cardPersonalId = 2,
            title = "Поступить в университет",
            description = "Вы решили пойти учиться дальше.",
            type = CardType.EDUCATION,
            statEffect = mapOf(EDUCATION to 2),
            tax = 1500,
            nextCardPersonalIds = WorkAfterUniversity.cards.map { it.cardPersonalId },
            backgroundImage = "image_university_admission.jpg"
        ),
        CardEntity(
            cardPersonalId = 3,
            title = "Сразу работать",
            description = "Решаете заработать денег.",
            type = CardType.JOB,
            statEffect = mapOf(RICHES to 2),
            nextCardPersonalIds = WorkWithoutUniversity.cards.map { it.cardPersonalId },
            backgroundImage = "image_immideatly_work.jpg"
        ),

        CardEntity(
            cardPersonalId = 300,
            title = "Этап взрослой жизни!",
            description = "Вам пора принять решение!",
            type = CardType.STATS,
            statEffect = mapOf(HEALTH to 1, RICHES to 2),
            nextCardPersonalIds = listOf(301, 302),
            backgroundImage = "image_amateur_live.jpg"
        ),
        CardEntity(
            cardPersonalId = 301,
            title = "Венчание",
            description = "Вы создаете семью. Здоровье +2, богатство -1",
            type = CardType.STATS,
            statEffect = mapOf(HEALTH to 2, RICHES to -1),
            nextCardPersonalIds = CardAfterMarried.cards.map { it.cardPersonalId },
            backgroundImage = "image_married.jpg"
        ),
        CardEntity(
            cardPersonalId = 302,
            title = "Карьера",
            description = "Вы выбираете карьерный путь",
            type = CardType.STATS,
            statEffect = mapOf(RICHES to 3, EDUCATION to 1),
            nextCardPersonalIds = CardAfterCareer.cards.map { it.cardPersonalId },
            backgroundImage = "image_carrier.jpg"
        ),
        CardEntity(
            cardPersonalId = 400,
            title = "Взрослые года",
            description = "Дети выросли, пора подумать и о себе!",
            type = CardType.STATS,
            statEffect = emptyMap(),
            nextCardPersonalIds = listOf(401, 402),
            backgroundImage = "image_old_room.jpg"
        ),
        CardEntity(
            cardPersonalId = 401,
            title = "Спокойная жизнь",
            description = "Работать и делать накопления",
            type = CardType.STATS,
            statEffect = emptyMap(),
            nextCardPersonalIds = MatureCardRest.cards.map { it.cardPersonalId },
            backgroundImage = "image_adult_years_1.jpg"
        ),
        CardEntity(
            cardPersonalId = 402,
            title = "Хобби и путешествия",
            description = "Пора постигать новое, хобби, путешествовать, развлечения!",
            type = CardType.STATS,
            statEffect = emptyMap(),
            nextCardPersonalIds = MatureCardHobbie.cards.map { it.cardPersonalId },
            backgroundImage = "image_adult_years_2.jpg"
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
