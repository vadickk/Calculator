package com.isurtionlsa.calculator.events

import com.isurtionlsa.calculator.data.MathOperation

sealed class CalculatorEvent {
    data class NumEvent(val number: Int): CalculatorEvent()
    object ClearUiEvent: CalculatorEvent()
    object RemoveUiEvent: CalculatorEvent()
    object DecimalUiEvent: CalculatorEvent()
    object CalcUiEvent: CalculatorEvent()
    data class OperationEvent(val operation: MathOperation): CalculatorEvent()
}