package com.isurtionlsa.calculator.data

data class CalculatorState(
    val number_first: String = "",
    val number_second: String = "",
    val result_operation: MathOperation? = null
)