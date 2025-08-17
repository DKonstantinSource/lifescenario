package lifescenario.com.data.db.entity.map

import androidx.room.TypeConverter

class IntListConverter {
    @TypeConverter
    fun fromList(list: List<Int>): String = list.joinToString(",")

    @TypeConverter
    fun toList(data: String): List<Int> =
        if (data.isBlank()) emptyList()
        else data.split(",").map { it.toInt() }
}
