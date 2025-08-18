package lifescenario.com.data.manager.cards.mature


import lifescenario.com.data.db.entity.CardEntity
import lifescenario.com.data.db.entity.CardType
import lifescenario.com.data.db.entity.stat.PersonalStat.*

object MatureCardRest {
    val cards = listOf(
        CardEntity(
            cardPersonalId = 401,
            title = "Спокойная жизнь",
            description = "Работать и делать накопления",
            type = CardType.STATS,
            statEffect = mapOf(RICHES to 3),
            salary = 2500,
            tax = 450,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 402,
            title = "Финансовое планирование",
            description = "Оптимизация бюджета и расходов",
            type = CardType.STATS,
            statEffect = mapOf(RICHES to 2),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 403,
            title = "Инвестиции",
            description = "Размещение денег в активы",
            type = CardType.JOB,
            statEffect = mapOf(RICHES to 3),
            salary = 2200,
            tax = 350,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 404,
            title = "Накопления",
            description = "Увеличение подушки безопасности",
            type = CardType.STATS,
            statEffect = mapOf(RICHES to 2),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 405,
            title = "Дополнительный доход",
            description = "Мелкие проекты и подработка",
            type = CardType.JOB,
            statEffect = mapOf(RICHES to 2),
            salary = 1800,
            tax = 300,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 406,
            title = "Семейный бюджет",
            description = "Контроль расходов и экономия",
            type = CardType.STATS,
            statEffect = mapOf(RICHES to 1),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 407,
            title = "Финансовая дисциплина",
            description = "Систематические накопления",
            type = CardType.STATS,
            statEffect = mapOf(RICHES to 2),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 408,
            title = "Пенсионные вложения",
            description = "Долгосрочные сбережения",
            type = CardType.JOB,
            statEffect = mapOf(RICHES to 2),
            salary = 2000,
            tax = 400,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 409,
            title = "Контроль расходов",
            description = "Минимизация ненужных трат",
            type = CardType.STATS,
            statEffect = mapOf(RICHES to 1),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 410,
            title = "Анализ финансов",
            description = "Регулярная проверка бюджета и доходов",
            type = CardType.STATS,
            statEffect = mapOf(RICHES to 2),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        )
    )
}
