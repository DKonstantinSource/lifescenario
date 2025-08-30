package lifescenario.com.data.manager.cards

import lifescenario.com.data.db.entity.CardEntity
import lifescenario.com.data.db.entity.CardType
import lifescenario.com.data.db.entity.stat.PersonalStat.*

object WorldEvents {

    val events = listOf(
        CardEntity(
            cardPersonalId = 201,
            title = "Торнадо в городе",
            description = "Сильный торнадо разрушил часть города, теряете часть богатства и здоровье!",
            type = CardType.EVENT,
            statEffect = mapOf(RICHES to -3, HEALTH to -2),
            tax = -1500,
            backgroundImage = "image_tornado.jpg"
        ),
        CardEntity(
            cardPersonalId = 202,
            title = "Карантин",
            description = "Вирус охватил город, здоровье падает, расходы на медицину растут",
            type = CardType.EVENT,
            statEffect = mapOf(HEALTH to -3, RICHES to -2),
            tax = -1000,
            backgroundImage = "image_quarantine.jpg"
        ),
        CardEntity(
            cardPersonalId = 203,
            title = "Пожар в квартале",
            description = "Пожар уничтожил имущество, теряете деньги и здоровье",
            type = CardType.EVENT,
            statEffect = mapOf(RICHES to -2, HEALTH to -1),
            tax = -1500,
            backgroundImage = "image_world_in_fire.jpg"
        ),
        CardEntity(
            cardPersonalId = 204,
            title = "Лотерея",
            description = "Везение на вашей стороне! Получаете дополнительное богатство",
            type = CardType.EVENT,
            statEffect = mapOf(RICHES to 5),
            salary = 10000,
            backgroundImage = "image_lottery.jpg"
        ),
        CardEntity(
            cardPersonalId = 205,
            title = "Общественный проект",
            description = "Вы участвуете в проекте города, улучшаете образование, здоровье и богатство!",
            type = CardType.EVENT,
            statEffect = mapOf(EDUCATION to 2, HEALTH to 1, RICHES to 2),
            salary = 1000,
            backgroundImage = "image_community_service.jpg"
        ),
        CardEntity(
            cardPersonalId = 206,
            title = "Наводнение",
            description = "Наводнение затопило ваш район, теряете деньги",
            type = CardType.EVENT,
            statEffect = mapOf(RICHES to -2),
            tax = 1000,
            backgroundImage = "image_city_flood.jpg"
        ),
        CardEntity(
            cardPersonalId = 207,
            title = "Праздник города",
            description = "Город празднует пора заводить знакомства, получаете бонус к здоровью и богатству!",
            type = CardType.EVENT,
            statEffect = mapOf(HEALTH to 2, RICHES to 1),
            salary = 1400,
            backgroundImage = "image_holiday_city.jpg"
        ),
        CardEntity(
            cardPersonalId = 208,
            title = "Экономический кризис",
            description = "Цены растут, теряете часть дохода",
            type = CardType.EVENT,
            statEffect = mapOf(RICHES to -3),
            tax = -3000,
            backgroundImage = "image_economy_crysis.jpg"
        ),
        CardEntity(
            cardPersonalId = 209,
            title = "Благотворительность",
            description = "Помогаете городу, улучшаете образование и здоровье",
            type = CardType.EVENT,
            statEffect = mapOf(EDUCATION to 2, HEALTH to 2),
            tax = -500,
            backgroundImage = "image_charity.jpg"
        ),
        CardEntity(
            cardPersonalId = 210,
            title = "Спортивный марафон",
            description = "Участие в марафоне укрепляет здоровье",
            type = CardType.EVENT,
            statEffect = mapOf(HEALTH to 3),
            backgroundImage = "image_city_maraphone.jpg"
        ),
        CardEntity(
            cardPersonalId = 211,
            title = "Землетрясение",
            description = "Стихийное бедствие в городе, теряете богатство и здоровье",
            type = CardType.EVENT,
            statEffect = mapOf(RICHES to -3, HEALTH to -2),
            tax = -1000,
            backgroundImage = "image_earthquake.jpg"
        ),
        CardEntity(
            cardPersonalId = 212,
            title = "Волонтёрство",
            description = "Помогаете нуждающимся, повышаете образование и здоровье",
            type = CardType.EVENT,
            statEffect = mapOf(EDUCATION to 1, HEALTH to 2),
            tax = 1000,
            backgroundImage = "image_charity.jpg"
        ),
        CardEntity(
            cardPersonalId = 213,
            title = "Кибератака на город",
            description = "Ваши деньги украдены, теряете богатство",
            type = CardType.EVENT,
            statEffect = mapOf(RICHES to -2),
            tax = -10000,
            backgroundImage = "image_cyber.jpg"
        ),
        CardEntity(
            cardPersonalId = 214,
            title = "Торговый успех",
            description = "Удачный бизнес приносит доход",
            type = CardType.EVENT,
            statEffect = mapOf(RICHES to 3),
            salary = 1800,
            backgroundImage = "image_arrow_up.jpg"
        ),
        CardEntity(
            cardPersonalId = 215,
            title = "Пожертвования в музей",
            description = "Улучшается образование и культура",
            type = CardType.EVENT,
            statEffect = mapOf(EDUCATION to 3),
            tax = 1000,
            backgroundImage = "image_bla_museum.jpg"
        ),
        CardEntity(
            cardPersonalId = 216,
            title = "Пробки в городе",
            description = "Траты времени,богатство и здоровье падает",
            type = CardType.EVENT,
            statEffect = mapOf(HEALTH to -2, MONEY to -1),
            tax = 400,
            backgroundImage = "image_traffic.jpg"
        ),
        CardEntity(
            cardPersonalId = 217,
            title = "Культурный фестиваль",
            description = "Повышает образование и настроение, время отдохнуть",
            type = CardType.EVENT,
            statEffect = mapOf(EDUCATION to 1, HEALTH to 2),
            tax = 500,
            backgroundImage = "image_fest.jpg"
        ),
        CardEntity(
            cardPersonalId = 218,
            title = "Пожар в лесу",
            description = "Воздействие на городскую экосистему, ввод сборов на локализацию!",
            type = CardType.EVENT,
            statEffect = mapOf(HEALTH to -2, RICHES to -2),
            tax = 800,
            backgroundImage = "image_wild_fire.jpg"
        ),
        CardEntity(
            cardPersonalId = 219,
            title = "Волна инноваций",
            description = "Новые технологии улучшают жизнь",
            type = CardType.EVENT,
            statEffect = mapOf(EDUCATION to 1, RICHES to 1),
            salary = 1000,
            backgroundImage = "image_hight_tech.jpg"
        ),
        CardEntity(
            cardPersonalId = 220,
            title = "Мировой конкурс",
            description = "Вы побеждаете в международном конкурсе, бонус к богатству и образованию",
            type = CardType.EVENT,
            statEffect = mapOf(RICHES to 2, EDUCATION to 2),
            salary = 2000,
            backgroundImage = "image_world_olympiad.jpg"
        ),
        CardEntity(
            cardPersonalId = 221,
            title = "Работа в поте лица",
            description = "Вы работаете как не в себя! ",
            type = CardType.EVENT,
            salary = 2500,
            statEffect = mapOf(RICHES to 2, EDUCATION to 2, HEALTH to -3),
            backgroundImage = "image_many_work.jpg"
        )



    )

    fun getRandomEvent(): CardEntity? {
        return events.randomOrNull()
    }

    fun getRandomEvents(count: Int): List<CardEntity> {
        return events.shuffled().take(count)
    }

    fun applySalary(card: CardEntity, currentMoney: Int): CardEntity {
        val salary = card.salary ?: 0
        return card.copy(value = currentMoney + salary)
    }

    fun applyTax(card: CardEntity, currentMoney: Int): CardEntity {
        val tax = card.tax ?: 0
        return card.copy(value = currentMoney - tax)
    }

}
