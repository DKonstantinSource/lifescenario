package lifescenario.com

import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import lifescenario.com.ui.screen.StartGameScreen
import lifescenario.com.ui.theme.TouchingWordsTheme

class HostActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        launchApp()
        setupFullscreen()
    }

    private fun launchApp() {
        setContent {
            TouchingWordsTheme {
                StartGameScreen(
                    onNewLifeClick = {
                        // TODO: Реализовать логику новой жизни
                    },
                    onBetterLifeClick = {
                        // TODO: Реализовать логику лучшей жизни
                    },
                    onSettingsClick = {
                        // TODO: Реализовать логику настроек
                    }
                )

            }
        }
    }

    private fun setupFullscreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.let {
                it.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                it.systemBarsBehavior =
                    WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        }
        WindowCompat.getInsetsController(window, window.decorView)?.isAppearanceLightStatusBars = false
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) setupFullscreen()
    }

    override fun onResume() {
        super.onResume()
        window.decorView.postDelayed({
            setupFullscreen()
        }, 100)
    }
}
