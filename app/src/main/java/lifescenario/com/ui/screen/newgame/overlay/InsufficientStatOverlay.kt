package lifescenario.com.ui.screen.newgame.overlay

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import lifescenario.com.data.db.entity.stat.PersonalStat
import lifescenario.com.data.db.entity.stat.displayName


@Composable
fun InsufficientStatOverlay(
    missingStats: List<PersonalStat>,
    totalCost: Int,
    canAfford: Boolean,
    onBuy: () -> Unit,
    onCancel: () -> Unit
) {
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
                .widthIn(max = 300.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Не хватает атрибутов: ${
                    missingStats.joinToString(", ") { it.displayName() }
                }",
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Восстановить за $totalCost монет?",
                color = Color.DarkGray
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
        }
    }
}
