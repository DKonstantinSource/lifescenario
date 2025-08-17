package lifescenario.com.ui.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import lifescenario.com.ui.screen.mainscreen.StartGameScreen
import lifescenario.com.ui.screen.newgame.GameScreen

import lifescenario.com.ui.viewmodel.GameViewModel

sealed class Screen(val route: String) {
    object Start : Screen("start_screen")
    object Game : Screen("game_screen")
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    gameViewModel: GameViewModel
) {
    NavHost(navController = navController, startDestination = Screen.Start.route) {
        composable(Screen.Start.route) {
            StartGameScreen(
                viewModel = gameViewModel,
                onSettingsClick = { /* пока не реализовано */ },
                onNewGameClick = {
                    navController.navigate(Screen.Game.route)
                }
            )
        }

        composable(Screen.Game.route) {
            GameScreen(viewModel = gameViewModel)
        }
    }
}
