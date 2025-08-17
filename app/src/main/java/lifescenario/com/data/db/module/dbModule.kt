package lifescenario.com.data.db.module

import androidx.room.Room
import lifescenario.com.data.db.AppDatabase
import lifescenario.com.data.db.bestscore.BestScoreRepository
import lifescenario.com.data.db.bestscore.BestScoreRepositoryContract
import lifescenario.com.data.db.card.CardRepository
import lifescenario.com.data.db.card.CardRepositoryContract
import lifescenario.com.data.manager.CardGameRepositoryContract
import lifescenario.com.data.manager.CardGameRepositoryImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dbModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            "lifescenario_db"
        ).build()
    }

    single { get<AppDatabase>().cardDao() }
    single { get<AppDatabase>().bestScoreDao() }

    single<CardRepositoryContract> { CardRepository(get()) }
    single<BestScoreRepositoryContract> { BestScoreRepository(get()) }


    single<CardGameRepositoryContract> { CardGameRepositoryImpl() }
}
