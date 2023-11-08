package com.isurtionlsa.calculator.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.isurtionlsa.calculator.data.CalculatorState
import com.isurtionlsa.calculator.data.MathOperation
import com.isurtionlsa.calculator.events.CalculatorEvent

class CoreViewModel : ViewModel() {
    var currentState by mutableStateOf(CalculatorState())

    private fun deleteLastCharacter() {
        when {
            currentState.number_second.isNotBlank() -> currentState = currentState.copy(number_second = currentState.number_second.dropLast(1))
            currentState.result_operation != null -> currentState = currentState.copy(result_operation = null)
            currentState.number_first.isNotBlank() -> currentState = currentState.copy(number_first = currentState.number_first.dropLast(1))
        }
    }

    private fun applyOperation(selectedOperation: MathOperation) {
        if (currentState.number_first.isNotBlank()) {
            currentState = currentState.copy(result_operation = selectedOperation)
        }
    }

    private fun addDecimal() {
        if (currentState.result_operation == null && !currentState.number_first.contains('.') && currentState.number_first.isNotBlank()) {
            currentState = currentState.copy(number_first = currentState.number_first + '.')
            return
        }
        if (!currentState.number_second.contains('.') && currentState.number_second.isNotBlank()) {
            currentState = currentState.copy(number_first = currentState.number_second + '.')
        }
    }

    private fun enterNumber(number: Int) {
        if (currentState.result_operation == null) {
            if (currentState.number_first.length >= 8) return
            currentState = currentState.copy(number_first = currentState.number_first + number)
            return
        }

        if (currentState.number_second.length >= 8) return
        currentState = currentState.copy(number_second = currentState.number_second + number)
    }

    private fun calculateResult() {
        val num1 = currentState.number_first.toDoubleOrNull()
        val num2 = currentState.number_second.toDoubleOrNull()

        if (num1 != null && num2 != null) {
            val result = when (currentState.result_operation) {
                is MathOperation.Add -> num1 + num2
                is MathOperation.Subtract -> num1 - num2
                is MathOperation.Divide -> num1 / num2
                is MathOperation.Multiply -> num1 * num2
                null -> return
            }
            currentState = currentState.copy(
                number_first = result.toString().take(15),
                number_second = "",
                result_operation = null
            )
        }
    }

    fun handleUserAction(action: CalculatorEvent) {
        when (action) {
            is CalculatorEvent.NumEvent -> enterNumber(action.number)
            is CalculatorEvent.DecimalUiEvent -> addDecimal()
            is CalculatorEvent.ClearUiEvent -> currentState = CalculatorState()
            is CalculatorEvent.OperationEvent -> applyOperation(action.operation)
            is CalculatorEvent.CalcUiEvent -> calculateResult()
            is CalculatorEvent.RemoveUiEvent -> deleteLastCharacter()
        }
    }
}
