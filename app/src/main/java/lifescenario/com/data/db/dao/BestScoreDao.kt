package lifescenario.com.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import lifescenario.com.data.db.entity.BestScoreEntity

@Dao
interface BestScoreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(score: BestScoreEntity)

    @Query("SELECT * FROM best_scores LIMIT 1")
    fun getBestScore(): Flow<BestScoreEntity?>
}
