package com.isurtionlsa.calculator.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.isurtionlsa.calculator.res.theme.MainSpapes

@Composable
fun RootCalculatorButton(
    buttonText: String,
    buttonTextColor: Color = Color.White,
    modifier: Modifier,
    onClick: () -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(MainSpapes.small)
            .clickable { onClick() }
            .then(modifier)
    ) {
        Text(
            text = buttonText,
            color = buttonTextColor,
            style = MaterialTheme.typography.displaySmall
        )
    }
}