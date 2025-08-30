package lifescenario.com.ui.screen.newgame


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lifescenario.com.R
import lifescenario.com.data.db.entity.CardEntity
import lifescenario.com.data.db.entity.stat.PersonalStat
import lifescenario.com.data.db.entity.stat.displayName
import kotlin.math.abs


@Composable
fun CardItemWithStats(
    card: CardEntity,
    onCardSelected: (CardEntity) -> Unit,
    modifier: Modifier = Modifier,
    backgroundAlpha: Float = 1f
) {
    Column(
        modifier = modifier
            .clickable { onCardSelected(card) }
            .background(Color.DarkGray.copy(alpha = backgroundAlpha), RoundedCornerShape(16.dp))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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

        Text(text = card.title, fontSize = 22.sp, color = Color.White)

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = card.description, fontSize = 16.sp, color = Color.White, maxLines = 4)

        Spacer(modifier = Modifier.height(8.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(
                    color = Color(0xFF3A3A3A),
                    shape = RoundedCornerShape(12.dp)
                )
                .border(
                    width = 1.dp,
                    color = Color.White.copy(alpha = 0.15f),
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(12.dp)
        ) {

            card.salary?.let { salary ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Зарплата +$salary",
                        fontSize = 14.sp,
                        color = Color(0xFF2ECC71)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_money),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = Color.Unspecified
                    )
                }
            }

            card.tax?.let { tax ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Налог -$tax",
                        fontSize = 14.sp,
                        color = Color(0xFFE74C3C)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_money),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = Color.Unspecified
                    )
                }
            }

            if (card.priceCost != 0) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Стоимость -${card.priceCost}",
                        fontSize = 14.sp,
                        color = Color(0xFFE67E22)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_money),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = Color.Unspecified
                    )
                }
            }


            card.statEffect.forEach { (stat, value) ->
                val sign = if (value >= 0) "+" else "-"
                val color = if (value >= 0) Color(0xFF2ECC71) else Color(0xFFE74C3C)

                val iconRes = when (stat) {
                    PersonalStat.HEALTH -> R.drawable.ic_heart
                    PersonalStat.RICHES -> R.drawable.ic_pig
                    PersonalStat.EDUCATION -> R.drawable.ic_book
                    PersonalStat.MONEY -> R.drawable.ic_money
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "${stat.displayName()} $sign${abs(value)}",
                        fontSize = 14.sp,
                        color = color
                    )
                    Icon(
                        painter = painterResource(id = iconRes),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = Color.Unspecified
                    )
                }
            }
        }
    }
}
