package lifescenario.com.ui.screen.newgame

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import lifescenario.com.data.db.entity.CardEntity
import kotlin.math.abs
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalDensity



@Composable
fun CardSelectionScreen(
    cards: List<CardEntity>,
    onCardSelected: (CardEntity) -> Unit
) {
    if (cards.isEmpty()) return

    val cardWidth = 320.dp
    val cardSpacing = 40.dp
    val coroutineScope = rememberCoroutineScope()
    var currentIndex by remember { mutableStateOf(0) }
    var dragOffset by remember { mutableStateOf(0f) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(cards) {
                detectHorizontalDragGestures(
                    onDragEnd = {
                        if (dragOffset < -100 && currentIndex < cards.lastIndex) currentIndex++
                        else if (dragOffset > 100 && currentIndex > 0) currentIndex--
                        currentIndex = currentIndex.coerceIn(0, cards.lastIndex)

                        dragOffset = 0f
                    },

                    onHorizontalDrag = { _, delta ->
                        dragOffset += delta
                    }
                )
            },
        contentAlignment = Alignment.Center
    ) {
        val density = LocalDensity.current
        val cardOffsetPx = with(density) { (cardWidth.toPx() - cardSpacing.toPx()) }

        cards.forEachIndexed { index, card ->
            val offsetFromCenter = if (cards.size == 1) 0 else index - currentIndex

            val animatedOffset by animateFloatAsState(
                targetValue = offsetFromCenter * cardOffsetPx + dragOffset,
                animationSpec = tween(durationMillis = 250)
                    //300 prolag
            )

            val progressToCenter = (1f - (abs(offsetFromCenter.toFloat()) / 2f)).coerceIn(0f, 1f)
            val scale by animateFloatAsState(
                targetValue = 0.8f + 0.2f * progressToCenter,
                animationSpec = tween(300)
            )

            val zIndexValue = if (index == currentIndex) 1f else 0f

            Box(
                modifier = Modifier
                    .width(cardWidth)
                    .graphicsLayer {
                        translationX = animatedOffset
                        scaleX = scale
                        scaleY = scale
                        this.alpha = alpha
                    }
                    .zIndex(zIndexValue)
                    .align(Alignment.Center)
            ) {
                CardItemWithStats(card = card, onCardSelected = onCardSelected)
            }
        }
    }
}



@Composable
fun getDrawableFromName(name: String): Int {
    val context = LocalContext.current
    return context.resources.getIdentifier(
        name.substringBeforeLast("."),
        "drawable",
        context.packageName
    )
}
