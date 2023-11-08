package com.isurtionlsa.calculator.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.isurtionlsa.calculator.data.CalculatorState

@Composable
fun ResultText(state: CalculatorState) {
    val reuslt = state.number_first + state.result_operation?.value.orEmpty() + state.number_second
    Text(
        text = reuslt,
        textAlign = TextAlign.End,
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        fontSize = 80.sp,
        lineHeight = 80.sp,
        fontWeight = FontWeight.Light,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        maxLines = 2
    )
}