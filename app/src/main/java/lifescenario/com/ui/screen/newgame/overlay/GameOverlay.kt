package lifescenario.com.ui.screen.newgame.overlay

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lifescenario.com.R



@Composable
fun GameOverlay(
    money: Int,
    health: Int,
    riches: Int,
    education: Int,
    modifier: Modifier = Modifier
) {


    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(
                color = Color.Black.copy(alpha = 0.3f),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        StatItem(iconRes = R.drawable.ic_money, value = money)
        StatItem(iconRes = R.drawable.ic_heart, value = health)
        StatItem(iconRes = R.drawable.ic_pig, value = riches)
        StatItem(iconRes = R.drawable.ic_book, value = education)
    }
}

@Composable
fun StatItem(
    iconRes: Int,
    value: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(32.dp)
        )
        Text(text = value.toString(), color = Color.White, fontSize = 14.sp)
    }
}

