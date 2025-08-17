package lifescenario.com.data.manager.cards

import lifescenario.com.data.db.entity.CardEntity
import lifescenario.com.data.db.entity.CardType
import lifescenario.com.data.db.entity.stat.PersonalStat.*

object WorkWithoutUniversity {
    val cards = listOf(
        CardEntity(
            cardPersonalId = 101,
            title = "Работа курьером",
            description = "Начало карьеры без высшего образования",
            type = CardType.JOB,
            statEffect = mapOf(RICHES to 2, HEALTH to 3, EDUCATION to 1),
            salary = 1400,
            tax = 300,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 102,
            title = "Работа в магазине",
            description = "Первые деньги в кассе",
            type = CardType.JOB,
            statEffect = mapOf(RICHES to 1, HEALTH to 1, EDUCATION to 2),
            salary = 900,
            tax = 120,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 103,
            title = "Стажировка у строителей",
            description = "Учимся ремеслу и зарабатываем",
            type = CardType.JOB,
            statEffect = mapOf(RICHES to 2, HEALTH to -1, EDUCATION to 3),
            salary = 1000,
            tax = 150,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 104,
            title = "Повар",
            description = "Готовить еду, призвание!",
            type = CardType.JOB,
            statEffect = mapOf(RICHES to 1, HEALTH to 1),
            salary = 850,
            tax = 100,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 105,
            title = "Фриланс без опыта",
            description = "Самостоятельные проекты, нестабильный доход",
            type = CardType.JOB,
            statEffect = mapOf(RICHES to 2, EDUCATION to 1),
            salary = 700,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 106,
            title = "Работа в кафе",
            description = "Бариста или официант, опыт работы с людьми",
            type = CardType.JOB,
            statEffect = mapOf(RICHES to 1, HEALTH to 1),
            salary = 800,
            tax = 80,
            backgroundImage = "image_university.jpg"
        )
    )
}
