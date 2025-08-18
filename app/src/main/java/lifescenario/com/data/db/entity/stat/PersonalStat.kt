package lifescenario.com.data.db.entity.stat

enum class PersonalStat {
    HEALTH,
    RICHES,
    EDUCATION,
    MONEY
}

fun PersonalStat.displayName(): String = when (this) {
    PersonalStat.HEALTH -> "Здоровье"
    PersonalStat.RICHES -> "Богатство"
    PersonalStat.EDUCATION -> "Образование"
    PersonalStat.MONEY -> "Деньги"
}
