package com.isurtionlsa.calculator.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.isurtionlsa.calculator.R
import com.isurtionlsa.calculator.events.CalculatorEvent
import com.isurtionlsa.calculator.screens.getButtonEvent

@Composable
fun ButtonRow(buttons: List<String>, onAction: (CalculatorEvent) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        buttons.forEach { symbol ->
            val buttonModifier = when (symbol) {
                stringResource(R.string.button_0) -> Modifier
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .aspectRatio(2f)
                    .weight(2f)
                else -> Modifier
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .aspectRatio(1f)
                    .weight(1f)
            }

            RootCalculatorButton(
                buttonText = symbol,
                modifier = buttonModifier,
                onClick = { onAction(getButtonEvent(symbol)) }
            )
        }
    }
}