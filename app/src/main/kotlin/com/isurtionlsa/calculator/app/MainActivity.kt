package com.isurtionlsa.calculator.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.isurtionlsa.calculator.res.theme.MainAppCalcTheme
import com.isurtionlsa.calculator.screens.MainCalculatorScreen
import com.isurtionlsa.calculator.vm.CoreViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MainAppCalcTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = viewModel<CoreViewModel>()
                    val state = viewModel.currentState

                    MainCalculatorScreen(
                        calculatorState = state,
                        modifier = Modifier.fillMaxSize().padding(8.dp),
                        onAction = { viewModel.handleUserAction(it) }
                    )
                }
            }
        }
    }
}