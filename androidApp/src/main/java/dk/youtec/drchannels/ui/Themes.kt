package dk.youtec.drchannels.ui

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val lightThemeColors = Colors(
        primary = Color(0xFF4CAF50),
        primaryVariant = Color(0xFFF44336),
        secondary = Color(0xFF03DAC5),
        secondaryVariant = Color(0xFF0AC9F0),
        background = Color.Red,
        surface = Color.White,
        error = Color(0xFFB00020),
        onPrimary = Color.White,
        onSecondary = Color.White,
        onBackground = Color.Black,
        onSurface = Color.Black,
        onError = Color.White,
        isLight = true
)

val darkThemeColors = Colors(
        primary = Color(0xFF4CAF50),
        primaryVariant = Color(0xFFF44336),
        secondary = Color(0xFF03DAC5),
        secondaryVariant = Color(0xFF0AC9F0),
        background = Color(0xFF2B2A2A),
        surface = Color(0xFF2B2A2A),
        error = Color(0xFFCF6679),
        onPrimary = Color.White,
        onSecondary = Color.White,
        onBackground = Color.White,
        onSurface = Color.White,
        onError = Color.Black,
        isLight = false
)