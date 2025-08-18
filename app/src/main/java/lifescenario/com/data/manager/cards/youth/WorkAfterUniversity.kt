package lifescenario.com.data.manager.cards.youth

import lifescenario.com.data.db.entity.CardEntity
import lifescenario.com.data.db.entity.CardType
import lifescenario.com.data.db.entity.stat.PersonalStat.*

object WorkAfterUniversity {
    val cards = listOf(
        CardEntity(
            cardPersonalId = 151,
            title = "Менеджер логистики",
            description = "Начинаем карьеру после университета",
            type = CardType.JOB,
            statEffect = mapOf(RICHES to 3, EDUCATION to 1),
            salary = 2000,
            tax = 1100,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 152,
            title = "Научный сотрудник",
            description = "Начинаем карьеру после университета",
            type = CardType.JOB,
            statEffect = mapOf(EDUCATION to 3, RICHES to 1, HEALTH to 2),
            salary = 1400,
            tax = 450,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 153,
            title = "IT-специалист",
            description = "Начинаем карьеру после университета",
            type = CardType.JOB,
            statEffect = mapOf(RICHES to 4, EDUCATION to 1, HEALTH to 1),
            salary = 2500,
            tax = 2900,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 154,
            title = "Судья",
            description = "Начинаем карьеру после университета",
            type = CardType.JOB,
            statEffect = mapOf(RICHES to 3, EDUCATION to 2, HEALTH to 2),
            salary = 2200,
            tax = 1700,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 155,
            title = "Фриланс по профессии",
            description = "Дорога предпринимателя",
            type = CardType.JOB,
            statEffect = mapOf(RICHES to 1, EDUCATION to 2, HEALTH to 1),
            salary = 1900,
            tax = 200,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 156,
            title = "Пилот",
            description = "Начинаем карьеру после университета",
            type = CardType.JOB,
            statEffect = mapOf(RICHES to 4, EDUCATION to 1),
            salary = 2700,
            tax = 2000,
            backgroundImage = "image_university.jpg"
        )
    )
}