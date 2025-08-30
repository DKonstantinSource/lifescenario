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
            backgroundImage = "image_routine.jpg"
        ),
        CardEntity(
            cardPersonalId = 402,
            title = "Финансовое планирование",
            description = "Оптимизация бюджета и расходов",
            type = CardType.STATS,
            statEffect = mapOf(RICHES to 2),
            salary = 0,
            tax = 0,
            backgroundImage = "image_planering.jpg"
        ),
        CardEntity(
            cardPersonalId = 403,
            title = "Инвестиции",
            description = "Размещение денег в активы",
            type = CardType.JOB,
            statEffect = mapOf(RICHES to 3),
            salary = 2200,
            tax = 350,
            backgroundImage = "image_invitacion.jpg"
        ),
        CardEntity(
            cardPersonalId = 404,
            title = "Накопления",
            description = "Увеличение подушки безопасности",
            type = CardType.STATS,
            statEffect = mapOf(RICHES to 2),
            salary = 0,
            tax = 0,
            backgroundImage = "image_bank_safe.jpg"
        ),
        CardEntity(
            cardPersonalId = 405,
            title = "Дополнительный доход",
            description = "Мелкие проекты и подработка",
            type = CardType.JOB,
            statEffect = mapOf(RICHES to 1, HEALTH to -2),
            salary = 1800,
            backgroundImage = "image_part_time_job.jpg"
        ),
        CardEntity(
            cardPersonalId = 406,
            title = "Семейный бюджет",
            description = "Контроль расходов и экономия",
            type = CardType.STATS,
            statEffect = mapOf(RICHES to 2),
            salary = 0,
            tax = 0,
            backgroundImage = "image_family_budget.jpg"
        ),
        CardEntity(
            cardPersonalId = 407,
            title = "Финансовая дисциплина",
            description = "Обучения систематическим накоплениям",
            type = CardType.STATS,
            statEffect = mapOf(RICHES to 1, EDUCATION to 2),
            salary = 0,
            tax = 0,
            backgroundImage = "image_education_finance.jpg"
        ),
        CardEntity(
            cardPersonalId = 408,
            title = "Пенсионные вложения",
            description = "Долгосрочные сбережения",
            type = CardType.JOB,
            statEffect = mapOf(RICHES to 2),
            salary = 3000,
            backgroundImage = "image_pension_money.jpg"
        ),
        CardEntity(
            cardPersonalId = 409,
            title = "Контроль расходов",
            description = "Минимизация ненужных трат",
            type = CardType.STATS,
            statEffect = mapOf(RICHES to 1),
            salary = 0,
            tax = 0,
            backgroundImage = "image_cost_control.jpg"
        ),
        CardEntity(
            cardPersonalId = 410,
            title = "Анализ финансов",
            description = "Регулярная проверка бюджета и доходов",
            type = CardType.STATS,
            statEffect = mapOf(RICHES to 2),
            salary = 0,
            tax = 0,
            backgroundImage = "image_analysis_finance.jpg"
        )
    )
}
