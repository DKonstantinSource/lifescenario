package lifescenario.com.data.manager.cards.twostage

import lifescenario.com.data.db.entity.CardEntity
import lifescenario.com.data.db.entity.CardType
import lifescenario.com.data.db.entity.stat.PersonalStat.*

object CardAfterCareer {
    val cards = listOf(
        CardEntity(
            cardPersonalId = 305,
            title = "Повышение",
            description = "Ваш труд оценили! Доход растёт.",
            type = CardType.JOB,
            statEffect = mapOf(RICHES to 3),
            salary = 2500,
            tax = 400,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 306,
            title = "Выгорание",
            description = "Работа требует слишком много.",
            type = CardType.STATS,
            statEffect = mapOf(HEALTH to -3),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 307,
            title = "Переезд по работе",
            description = "Новая локация и опыт.",
            type = CardType.JOB,
            statEffect = mapOf(RICHES to 1, EDUCATION to 1),
            salary = 2200,
            tax = 350,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 308,
            title = "Участие в конференции",
            description = "Вы прокачали навыки и связи.",
            type = CardType.EDUCATION,
            statEffect = mapOf(EDUCATION to 2),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 309,
            title = "Открытие стартапа",
            description = "Рискованно, но перспективно.",
            type = CardType.JOB,
            statEffect = mapOf(RICHES to 2, EDUCATION to 1),
            salary = 1800,
            tax = 200,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 310,
            title = "Проект провален",
            description = "Вы теряете деньги и мотивацию.",
            type = CardType.STATS,
            statEffect = mapOf(RICHES to -2, HEALTH to -1),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 311,
            title = "Новый наставник",
            description = "Вы находите вдохновение и учитесь.",
            type = CardType.EDUCATION,
            statEffect = mapOf(EDUCATION to 1, HEALTH to 1),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 312,
            title = "Работа за границей",
            description = "Новые горизонты и испытания.",
            type = CardType.JOB,
            statEffect = mapOf(RICHES to 2, EDUCATION to 1),
            salary = 3000,
            tax = 500,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 313,
            title = "Учёба в магистратуре",
            description = "Вы растёте профессионально.",
            type = CardType.EDUCATION,
            statEffect = mapOf(EDUCATION to 2, RICHES to -1),
            salary = 0,
            tax = 0,
            backgroundImage = "image_university.jpg"
        ),
        CardEntity(
            cardPersonalId = 314,
            title = "Карьера в пике",
            description = "Вы добились признания.",
            type = CardType.STATS,
            statEffect = mapOf(RICHES to 4, HEALTH to -1),
            salary = 3500,
            tax = 600,
            backgroundImage = "image_university.jpg"
        )
    )
}
