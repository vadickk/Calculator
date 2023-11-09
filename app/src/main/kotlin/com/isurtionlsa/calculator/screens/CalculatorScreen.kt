package com.isurtionlsa.calculator.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.isurtionlsa.calculator.R
import com.isurtionlsa.calculator.data.MathOperation
import com.isurtionlsa.calculator.data.database.RequestHistoryItem
import com.isurtionlsa.calculator.events.CalculatorEvent
import com.isurtionlsa.calculator.views.ButtonRow
import com.isurtionlsa.calculator.views.ButtonRowForEquals
import com.isurtionlsa.calculator.views.CalculatorDisplay
import com.isurtionlsa.calculator.vm.CoreViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainCalculatorScreen(
    viewModel: CoreViewModel = hiltViewModel(),
    goToHistory: () -> Unit
) {
    val calculatorState by rememberUpdatedState(newValue = viewModel.currentState)
    var lastState by remember { mutableStateOf(calculatorState) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Calculator") },
                actions = {
                    IconButton(onClick = { goToHistory.invoke() }) {
                        Icon(imageVector = Icons.Default.List, contentDescription = "History")
                    }
                }
            )
        },
        content = { paddings ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = paddings.calculateTopPadding() + 10.dp
                    ),
                verticalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                if (calculatorState.number_first != "" && calculatorState.number_second != "") {
                    lastState = calculatorState
                }
                CalculatorDisplay(calculatorState)

                ButtonRow(
                    listOf(
                        stringResource(R.string.button_ac),
                        stringResource(R.string.button_del),
                        stringResource(R.string.button_divide)
                    )
                ) { viewModel.handleUserAction(it) }
                ButtonRow(
                    listOf(
                        stringResource(R.string.button_7),
                        stringResource(R.string.button_8),
                        stringResource(R.string.button_9),
                        stringResource(R.string.button_multiply)
                    ),
                ) { viewModel.handleUserAction(it) }
                ButtonRow(
                    listOf(
                        stringResource(R.string.button_4),
                        stringResource(R.string.button_5),
                        stringResource(R.string.button_6),
                        stringResource(R.string.button_subtract)
                    )
                ) { viewModel.handleUserAction(it) }
                ButtonRow(
                    listOf(
                        stringResource(R.string.button_1),
                        stringResource(R.string.button_2),
                        stringResource(R.string.button_3),
                        stringResource(R.string.button_add)
                    ),
                ) { viewModel.handleUserAction(it) }
                ButtonRowForEquals(
                    listOf(
                        stringResource(R.string.button_0),
                        stringResource(R.string.button_dot),
                        stringResource(R.string.button_equals)
                    ),
                    onAction = { viewModel.handleUserAction(it) },
                    onEquals = {
                        val type = when (lastState.result_operation) {
                            is MathOperation.Add -> "+"
                            is MathOperation.Divide -> "/"
                            is MathOperation.Multiply -> "*"
                            is MathOperation.Subtract -> "-"
                            else -> "+"
                        }
                        val res = viewModel.calculateResult(
                            lastState.number_first.toDoubleOrNull(),
                            lastState.number_second.toDoubleOrNull(),
                            lastState.result_operation
                        )
                        val requestHistoryItem = RequestHistoryItem(
                            result = "${lastState.number_first} $type ${lastState.number_second} = $res"
                        )
                        viewModel.addNewRequestHistory(requestHistoryItem)
                        Log.d("MyLog", requestHistoryItem.result)
                    }
                )
            }
        }
    )
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
