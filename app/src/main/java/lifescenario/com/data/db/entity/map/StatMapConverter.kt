package lifescenario.com.data.db.entity

import androidx.room.TypeConverter
import lifescenario.com.data.db.entity.stat.PersonalStat

class StatMapConverter {
    @TypeConverter
    fun fromMap(map: Map<PersonalStat, Int>): String =
        map.entries.joinToString(";") { "${it.key.name}:${it.value}" }

    @TypeConverter
    fun toMap(data: String): Map<PersonalStat, Int> =
        if (data.isBlank()) emptyMap()
        else data.split(";").associate {
            val (key, value) = it.split(":")
            PersonalStat.valueOf(key) to value.toInt()
        }
}
