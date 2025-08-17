package lifescenario.com

import android.app.Application
import lifescenario.com.data.db.module.dbModule
import lifescenario.com.data.manager.di.managerModule
import lifescenario.com.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class LifeScenarioApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@LifeScenarioApp)
            modules(
                dbModule,
                viewModelModule,
                managerModule,
                )
        }
    }
}
