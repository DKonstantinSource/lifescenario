package lifescenario.com.ui.screen.newgame


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lifescenario.com.data.db.entity.CardEntity



@Composable
fun CardItem(
    card: CardEntity,
    onCardSelected: (CardEntity) -> Unit
) {
    Box(
        modifier = Modifier
            .aspectRatio(9f / 16f)
            .shadow(8.dp, RoundedCornerShape(16.dp))
            .background(Color.DarkGray, RoundedCornerShape(16.dp))
            .clickable { onCardSelected(card) }
    ) {
        Image(
            painter = painterResource(id = getDrawableFromName(card.backgroundImage)),
            contentDescription = card.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(Color.Black.copy(alpha = 0.5f))
                .padding(12.dp)
        ) {
            Column {
                Text(
                    text = card.title,
                    color = Color.White,
                    fontSize = 20.sp,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = card.description,
                    color = Color.White,
                    fontSize = 14.sp,
                    maxLines = 3
                )
            }
        }
    }
}
