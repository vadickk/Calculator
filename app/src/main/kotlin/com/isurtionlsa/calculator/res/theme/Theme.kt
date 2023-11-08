package com.isurtionlsa.calculator.res.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColorScheme(
    primary = GreenPreLight,
    onPrimary = GreenTop,
    primaryContainer = GreenPreTop,
    onPrimaryContainer = GreenLight,
    inversePrimary = GreenMed,
    secondary = DarkGreen80,
    onSecondary = DarkGreen20,
    secondaryContainer = DarkGreen30,
    onSecondaryContainer = DarkGreen90,
    tertiary = Violet8,
    onTertiary = Violet2,
    tertiaryContainer = Violet3,
    onTertiaryContainer = Violet9,
    error = Orange1,
    onError = Red1,
    errorContainer = Red2,
    onErrorContainer = Orange2,
    background = GreyDark,
    onBackground = GreyLight,
    surface = GreenGreyDark,
    onSurface = GreenGreyLight,
    inverseSurface = GreyLight,
    inverseOnSurface = GreyDark,
    surfaceVariant = GreenGreyDark,
    onSurfaceVariant = GreenGreyLight,
    outline = GreenGreyLight
)

@Composable
fun MainAppCalcTheme(content: @Composable () -> Unit) {
    val colors = DarkColorPalette
    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = MainSpapes,
        content = content
    )
}