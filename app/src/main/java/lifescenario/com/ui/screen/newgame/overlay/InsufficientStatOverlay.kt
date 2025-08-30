package lifescenario.com.ui.screen.newgame.overlay

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lifescenario.com.data.db.entity.stat.PersonalStat
import lifescenario.com.data.db.entity.stat.displayName
import lifescenario.com.R
import lifescenario.com.ui.viewmodel.AdsViewModel
import lifescenario.com.ui.viewmodel.GameViewModel


@Composable
fun InsufficientStatOverlay(
    missingStats: Map<PersonalStat, Int>,
    money: Int,
    onBuy: () -> Unit,
    onCancel: () -> Unit,
    adsViewModel: AdsViewModel,
    gameViewModel: GameViewModel,
    onShowTotal: () -> Unit
) {
    val costPerStat = 500
    val totalCost = missingStats.values.sumOf { it * costPerStat }
    val canAfford = money >= totalCost

    val context = LocalContext.current
    val isAdAvailable = adsViewModel.isAdAvailable.collectAsState(initial = false).value
    val rewardEarned = adsViewModel.rewardEarned.collectAsState(initial = false).value

    LaunchedEffect(Unit) {
        (context as? Activity)?.let {
            adsViewModel.init(it)
            adsViewModel.loadAd()
        }
    }

    LaunchedEffect(rewardEarned) {
        if (rewardEarned) {
            gameViewModel.applyRewardStatsFromAd(missingStats)
            adsViewModel.clearReward()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0x99000000)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(16.dp))
                .padding(24.dp)
                .widthIn(max = 320.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Не хватает атрибутов:", color = Color.Black, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                missingStats.forEach { (stat, count) ->
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
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(id = iconRes),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("${stat.displayName()} x$count", color = Color.DarkGray)
                        }
                        Text("${count * costPerStat} монет", color = Color.Gray, fontSize = 14.sp)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Итого: $totalCost монет",
                color = if (canAfford) Color.Black else Color.Red,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Button(
                    onClick = onBuy,
                    enabled = canAfford,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF27AE60))
                ) {
                    Text("Купить")
                }
                OutlinedButton(onClick = onCancel) {
                    Text("Отмена")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(verticalArrangement = Arrangement.spacedBy(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {

                if (!canAfford) {
                    Button(
                        onClick = {
                            if (isAdAvailable) {
                                (context as? Activity)?.let { adsViewModel.showAd(it) }
                            } else {
                                adsViewModel.loadAd()
                            }
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFf1c40f))
                    ) {
                        Text(if (isAdAvailable) "Посмотреть рекламу" else "Загрузить рекламу")
                    }

                    Text(
                        "Посмотри рекламу, чтобы получить недостающие статы или деньги",
                        color = Color.DarkGray,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(horizontal = 4.dp)
                    )
                }

                OutlinedButton(onClick = onShowTotal) {
                    Text("Итог")
                }
            }

        }
    }
}
