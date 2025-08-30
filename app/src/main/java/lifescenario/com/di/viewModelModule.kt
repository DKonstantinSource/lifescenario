package lifescenario.com.di


import lifescenario.com.ui.viewmodel.AdsViewModel
import lifescenario.com.ui.viewmodel.FinanceViewModel
import lifescenario.com.ui.viewmodel.GameViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { GameViewModel(get(), get()) }
    viewModel { FinanceViewModel() }
    viewModel { AdsViewModel(get()) }
}
