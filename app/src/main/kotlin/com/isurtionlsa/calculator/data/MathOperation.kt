package com.isurtionlsa.calculator.data

sealed class MathOperation(val value: String) {
    object Add: MathOperation("+")
    object Subtract: MathOperation("-")
    object Multiply: MathOperation("×")
    object Divide: MathOperation("÷")
}