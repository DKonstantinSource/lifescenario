package lifescenario.com.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "best_scores")
data class BestScoreEntity(
    @PrimaryKey val id: Int = 0,
    val score: Int
)
