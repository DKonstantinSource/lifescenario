package lifescenario.com.data.db.bestscore

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import lifescenario.com.data.db.dao.BestScoreDao
import lifescenario.com.data.db.entity.BestScoreEntity

class BestScoreRepository(private val dao: BestScoreDao) : BestScoreRepositoryContract {

    override fun getBestScore(): Flow<BestScore?> {
        return dao.getBestScore().map { entity ->
            entity?.let { BestScore(it.score) }
        }
    }

    override suspend fun saveBestScore(score: BestScore) {
        val entity = BestScoreEntity(id = 0, score = score.score)
        dao.insert(entity)
    }
}

