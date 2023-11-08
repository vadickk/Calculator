package com.isurtionlsa.calculator.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.isurtionlsa.calculator.R
import com.isurtionlsa.calculator.data.CalculatorState
import com.isurtionlsa.calculator.data.MathOperation
import com.isurtionlsa.calculator.events.CalculatorEvent
import com.isurtionlsa.calculator.views.ButtonRow
import com.isurtionlsa.calculator.views.CalculatorDisplay

@Composable
fun MainCalculatorScreen(
    calculatorState: CalculatorState,
    modifier: Modifier = Modifier,
    onAction: (CalculatorEvent) -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            CalculatorDisplay(calculatorState)

            ButtonRow(
                listOf(
                    stringResource(R.string.button_ac),
                    stringResource(R.string.button_del),
                    stringResource(R.string.button_divide)
                ),
                onAction
            )
            ButtonRow(
                listOf(
                    stringResource(R.string.button_7),
                    stringResource(R.string.button_8),
                    stringResource(R.string.button_9),
                    stringResource(R.string.button_multiply)
                ),
                onAction
            )
            ButtonRow(
                listOf(
                    stringResource(R.string.button_4),
                    stringResource(R.string.button_5),
                    stringResource(R.string.button_6),
                    stringResource(R.string.button_subtract)
                ),
                onAction
            )
            ButtonRow(
                listOf(
                    stringResource(R.string.button_1),
                    stringResource(R.string.button_2),
                    stringResource(R.string.button_3),
                    stringResource(R.string.button_add)
                ),
                onAction
            )
            ButtonRow(
                listOf(
                    stringResource(R.string.button_0),
                    stringResource(R.string.button_dot),
                    stringResource(R.string.button_equals)
                ),
                onAction
            )
        }
    }
}


fun getButtonEvent(symbol: String): CalculatorEvent {
    return when (symbol) {
        "AC" -> CalculatorEvent.ClearUiEvent
        "Del" -> CalculatorEvent.RemoveUiEvent
        "/" -> CalculatorEvent.OperationEvent(MathOperation.Divide)
        "*" -> CalculatorEvent.OperationEvent(MathOperation.Multiply)
        "-" -> CalculatorEvent.OperationEvent(MathOperation.Subtract)
        "+" -> CalculatorEvent.OperationEvent(MathOperation.Add)
        "0" -> CalculatorEvent.NumEvent(0)
        "1" -> CalculatorEvent.NumEvent(1)
        "2" -> CalculatorEvent.NumEvent(2)
        "3" -> CalculatorEvent.NumEvent(3)
        "4" -> CalculatorEvent.NumEvent(4)
        "5" -> CalculatorEvent.NumEvent(5)
        "6" -> CalculatorEvent.NumEvent(6)
        "7" -> CalculatorEvent.NumEvent(7)
        "8" -> CalculatorEvent.NumEvent(8)
        "9" -> CalculatorEvent.NumEvent(9)
        "." -> CalculatorEvent.DecimalUiEvent
        "=" -> CalculatorEvent.CalcUiEvent
        else -> throw Exception("Errorrrr")
    }
}
