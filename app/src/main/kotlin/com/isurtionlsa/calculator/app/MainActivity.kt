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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.isurtionlsa.calculator.res.theme.MainAppCalcTheme
import com.isurtionlsa.calculator.screens.HistoryScreen
import com.isurtionlsa.calculator.screens.MainCalculatorScreen
import com.isurtionlsa.calculator.vm.CoreViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainAppCalcTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "main"
                ) {
                    composable("main") {
                        MainCalculatorScreen {
                            navController.navigate("history")
                        }
                    }

                    composable(
                        route = "history"
                    ) {
                        HistoryScreen {
                            navController.popBackStack()
                        }
                    }
                }
            }
        }
    }
}