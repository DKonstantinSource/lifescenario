package lifescenario.com.data.manager.di

import lifescenario.com.data.manager.CardManager
import lifescenario.com.data.manager.CardManagerContract
import org.koin.dsl.module

val managerModule = module {

    single<CardManagerContract> { CardManager(get()) }
}