package lifescenario.com.ui.screen.newgame

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lifescenario.com.data.db.entity.CardEntity

@Composable
fun CardSelectionScreen(
    cards: List<CardEntity>,
    onCardSelected: (CardEntity) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .wrapContentWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            cards.take(2).forEach { card ->
                CardItemWithStats(
                    card = card,
                    onCardSelected = onCardSelected,
                    modifier = Modifier.width(160.dp) // фиксированная ширина, чтобы была одна или две карты
                )
            }
        }
    }
}

@Composable
fun CardItemWithStats(
    card: CardEntity,
    onCardSelected: (CardEntity) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clickable { onCardSelected(card) }
            .background(Color.DarkGray, RoundedCornerShape(16.dp))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Квадратное изображение
        Image(
            painter = painterResource(id = getDrawableFromName(card.backgroundImage)),
            contentDescription = card.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(12.dp))
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = card.title,
            fontSize = 18.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = card.description,
            fontSize = 14.sp,
            color = Color.White,
            maxLines = 2
        )

        Spacer(modifier = Modifier.height(8.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            card.statEffect.forEach { (stat, value) ->
                val sign = if (value >= 0) "+" else "-"
                Text(
                    text = "$stat $sign${kotlin.math.abs(value)}",
                    fontSize = 12.sp,
                    color = if (value >= 0) Color.Green else Color.Red
                )
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
