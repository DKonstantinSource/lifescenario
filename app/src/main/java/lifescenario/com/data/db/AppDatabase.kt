package lifescenario.com.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import lifescenario.com.data.db.dao.CardDao
import lifescenario.com.data.db.dao.BestScoreDao
import lifescenario.com.data.db.entity.CardEntity
import lifescenario.com.data.db.entity.BestScoreEntity
import lifescenario.com.data.db.entity.StatMapConverter
import lifescenario.com.data.db.entity.map.IntListConverter

@Database(entities = [CardEntity::class, BestScoreEntity::class], version = 1)
@TypeConverters(StatMapConverter::class, IntListConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cardDao(): CardDao
    abstract fun bestScoreDao(): BestScoreDao
}
