package lifescenario.com.data.manager.cards.mature


import lifescenario.com.data.db.entity.CardEntity
import lifescenario.com.data.db.entity.CardType
import lifescenario.com.data.db.entity.stat.PersonalStat.*

object MatureCardHobbie {
    val cards = listOf(
        CardEntity(
            cardPersonalId = 411,
            title = "Путешествия",
            description = "Исследование новых мест и культур",
            type = CardType.STATS,
            statEffect = mapOf(HEALTH to 1, RICHES to -2),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 412,
            title = "Спорт и фитнес",
            description = "Здоровый образ жизни",
            type = CardType.STATS,
            statEffect = mapOf(HEALTH to 2),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 413,
            title = "Творчество",
            description = "Музыка, рисование, развитие навыков",
            type = CardType.STATS,
            statEffect = mapOf(EDUCATION to 1, HEALTH to 1),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 414,
            title = "Новые курсы",
            description = "Постигать новое и развиваться",
            type = CardType.EDUCATION,
            statEffect = mapOf(EDUCATION to 2, MONEY to -1),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 415,
            title = "Велопутешествия",
            description = "Активный отдых на свежем воздухе",
            type = CardType.STATS,
            statEffect = mapOf(HEALTH to 2, RICHES to -1),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 416,
            title = "Искусство и выставки",
            description = "Посещение культурных событий",
            type = CardType.STATS,
            statEffect = mapOf(EDUCATION to 1),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 417,
            title = "Кулинарные эксперименты",
            description = "Новые вкусы и рецепты",
            type = CardType.STATS,
            statEffect = emptyMap(),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 418,
            title = "Волонтёрство",
            description = "Помощь другим и душевное удовлетворение",
            type = CardType.STATS,
            statEffect = mapOf(HEALTH to 1),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 419,
            title = "Йога и медитация",
            description = "Покой, здоровье и гармония",
            type = CardType.STATS,
            statEffect = mapOf(HEALTH to 2),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 420,
            title = "Поездка на природу",
            description = "Отдых на свежем воздухе",
            type = CardType.STATS,
            statEffect = mapOf(HEALTH to 1),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        )
    )
}