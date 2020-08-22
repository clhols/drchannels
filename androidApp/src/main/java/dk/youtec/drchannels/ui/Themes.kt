package dk.youtec.drchannels.ui

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val lightThemeColors = Colors(
        primary = Color(0xFF855446),
        primaryVariant = Color(0xFF9C684B),
        secondary = Color(0xFF03DAC5),
        secondaryVariant = Color(0xFF0AC9F0),
        background = Color.White,
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
        primary = Color(0xFF1F1F1F),
        primaryVariant = Color(0xFF3E2723),
        secondary = Color(0xFF03DAC5),
        secondaryVariant = Color(0xFF0AC9F0),
        background = Color(0xFF121212),
        surface = Color.Black,
        error = Color(0xFFCF6679),
        onPrimary = Color.White,
        onSecondary = Color.White,
        onBackground = Color.White,
        onSurface = Color.White,
        onError = Color.Black,
        isLight = false
)