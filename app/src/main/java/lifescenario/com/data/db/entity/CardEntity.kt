package lifescenario.com.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import lifescenario.com.data.db.entity.stat.PersonalStat

@Entity(tableName = "cards")
data class CardEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val cardPersonalId: Int,
    val title: String,
    val description: String,
    val type: CardType,
    val value: Int = 1000,
    val statEffect: Map<PersonalStat, Int> = emptyMap(),
    val nextCardPersonalIds: List<Int> = emptyList(),
    val backgroundImage: String = "",
    val salary: Int? = null,
    val tax: Int? = null
)
