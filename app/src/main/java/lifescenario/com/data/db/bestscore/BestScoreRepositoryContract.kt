package lifescenario.com.data.db.bestscore

import kotlinx.coroutines.flow.Flow

interface BestScoreRepositoryContract {
    fun getBestScore(): Flow<BestScore?>
    suspend fun saveBestScore(score: BestScore)
}
