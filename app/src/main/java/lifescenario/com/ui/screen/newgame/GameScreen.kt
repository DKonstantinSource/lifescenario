package lifescenario.com.ui.screen.newgame

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import lifescenario.com.ui.viewmodel.GameViewModel

@Composable
fun GameScreen(viewModel: GameViewModel) {
    val isIntroVisible = viewModel.isIntroVisible.collectAsState()
    val cards = viewModel.currentCards.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = listOf(Color(0xFF2ECC71), Color(0xFF1ABC9C)),
                    start = Offset(0f, 0f),
                    end = Offset(1000f, 2000f)
                )
            )
    ) {
        if (isIntroVisible.value) {
            IntroOverlay(
                onContinue = { viewModel.hideIntroAndStartGame() }
            )
        } else {
            if (cards.value.isNotEmpty()) {
                CardSelectionScreen(
                    cards = cards.value,
                    onCardSelected = { selected ->
                        viewModel.selectCard(selected)
                    }
                )
            }
        }
    }
}
