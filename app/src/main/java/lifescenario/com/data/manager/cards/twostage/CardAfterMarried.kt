package lifescenario.com.data.manager.cards.twostage


import lifescenario.com.data.db.entity.CardEntity
import lifescenario.com.data.db.entity.CardType
import lifescenario.com.data.db.entity.stat.PersonalStat.*

object CardAfterMarried {
    val cards = listOf(
        CardEntity(
            cardPersonalId = 351,
            title = "Первый ребёнок",
            description = "Вы стали родителями! Счастье и заботы.",
            type = CardType.FAMILY,
            statEffect = mapOf(RICHES to -2, HEALTH to 2),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 352,
            title = "Семейный отпуск",
            description = "Незабываемое путешествие всей семьёй.",
            type = CardType.EVENT,
            statEffect = mapOf(HEALTH to 2, RICHES to -1),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 353,
            title = "Ремонт квартиры",
            description = "Комфорт важнее кошелька.",
            type = CardType.EVENT,
            statEffect = mapOf(RICHES to -3, HEALTH to 1),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 354,
            title = "Поддержка супруга",
            description = "Вдохновение и душевное равновесие.",
            type = CardType.STATS,
            statEffect = mapOf(HEALTH to 1, EDUCATION to 1),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 355,
            title = "Семейный праздник",
            description = "День рождения, юбилей, или годовщина.",
            type = CardType.EVENT,
            statEffect = mapOf(HEALTH to 1),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 356,
            title = "Проблемы в браке",
            description = "Нужно время и работа над собой.",
            type = CardType.STATS,
            statEffect = mapOf(HEALTH to -2),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 357,
            title = "Рождение второго ребёнка",
            description = "Семья становится больше.",
            type = CardType.FAMILY,
            statEffect = mapOf(RICHES to -2, HEALTH to 1),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 358,
            title = "Семейный бизнес",
            description = "Запускаете дело вместе с партнёром.",
            type = CardType.JOB,
            statEffect = mapOf(RICHES to 2),
            salary = 1500,
            tax = 200,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 359,
            title = "Семейная терапия",
            description = "Вы решаете внутренние конфликты.",
            type = CardType.EVENT,
            statEffect = mapOf(HEALTH to 2),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 360,
            title = "Семейное волонтёрство",
            description = "Вы вместе помогаете другим.",
            type = CardType.EVENT,
            statEffect = mapOf(HEALTH to 1, EDUCATION to 1),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        )
    )
}

