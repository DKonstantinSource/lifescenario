package lifescenario.com.data.manager.cards.home

import lifescenario.com.data.db.entity.CardEntity
import lifescenario.com.data.db.entity.CardType
import lifescenario.com.data.db.entity.stat.PersonalStat.*

object CardHomeBuying {
    val cards = listOf(
        CardEntity(
            cardPersonalId = 401,
            title = "Квартира-студия",
            description = "Небольшая квартира в городе. Удобно и недорого.",
            type = CardType.STATS,
            statEffect = mapOf(HEALTH to 1, RICHES to -2),
            salary = 0,
            tax = 450,
            bonusScoreHomeBuying = 4000,
            backgroundImage = "image_apartment_studio.jpg"
        ),
        CardEntity(
            cardPersonalId = 402,
            title = "Однокомнатная квартира",
            description = "Комфортное жильё для одного или пары.",
            type = CardType.STATS,
            statEffect = mapOf(HEALTH to 2, RICHES to -3),
            salary = 0,
            tax = 900,
            bonusScoreHomeBuying = 5500,
            backgroundImage = "image_one_room_apartment.jpg"
        ),
        CardEntity(
            cardPersonalId = 404,
            title = "Таунхаус",
            description = "Дом с небольшим участком, уютно и просторно.",
            type = CardType.STATS,
            statEffect = mapOf(HEALTH to 3, RICHES to -6),
            salary = 0,
            tax = 2000,
            bonusScoreHomeBuying = 6000,
            backgroundImage = "image_townhouse.jpg"
        ),
        CardEntity(
            cardPersonalId = 405,
            title = "Загородный дом",
            description = "Просторный дом за городом. Тишина и свежий воздух.",
            type = CardType.STATS,
            statEffect = mapOf(HEALTH to 4, RICHES to -8),
            salary = 0,
            tax = 3000,
            bonusScoreHomeBuying = 6000,
            backgroundImage = "image_country_house.jpg"
        ),
        CardEntity(
            cardPersonalId = 405,
            title = "Роскошный загородный дом",
            description = "Просторный дом за городом. Тишина и свежий воздух.",
            type = CardType.STATS,
            statEffect = mapOf(HEALTH to 4, RICHES to -8),
            salary = 0,
            tax = 3000,
            bonusScoreHomeBuying = 8000,
            backgroundImage = "image_luxury_country_house.jpg"
        ),
        CardEntity(
            cardPersonalId = 406,
            title = "Роскошный особняк",
            description = "Всё, о чём можно мечтать. Богатство тратится, здоровье растёт.",
            type = CardType.STATS,
            statEffect = mapOf(HEALTH to 5, RICHES to -12),
            salary = 0,
            tax = 4000,
            bonusScoreHomeBuying = 10000,
            backgroundImage = "image_mansion.jpg"
        )
    )
}
