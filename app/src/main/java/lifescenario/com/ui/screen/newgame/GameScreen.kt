package lifescenario.com.ui.screen.newgame

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import lifescenario.com.ui.screen.newgame.overlay.GameOverlay
import lifescenario.com.ui.screen.newgame.overlay.InsufficientStatOverlay
import lifescenario.com.ui.viewmodel.GameViewModel

@Composable
fun GameScreen(viewModel: GameViewModel) {
    LaunchedEffect(Unit) {
        viewModel.resetIntro()
    }

    val isIntroVisible = viewModel.isIntroVisible.collectAsState()
    val cards = viewModel.currentCards.collectAsState()
    val money = viewModel.money.collectAsState()
    val health = viewModel.health.collectAsState()
    val riches = viewModel.riches.collectAsState()
    val education = viewModel.education.collectAsState()

    val statInsufficient = viewModel.showInsufficientStatOverlay.collectAsState()
    val canAfford = money.value >= viewModel.statPurchaseCost

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

            GameOverlay(
                money = money.value,
                health = health.value,
                riches = riches.value,
                education = education.value,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
            )
        }

        if (statInsufficient.value != null) {
            InsufficientStatOverlay(
                stat = statInsufficient.value!!,
                canAfford = canAfford,
                onBuy = { viewModel.buyStatToApplyPendingCard() },
                onCancel = { viewModel.cancelStatPurchase() }
            )
        }
    }
}
