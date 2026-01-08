package com.wsircam.taskmanagement.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    background = eerieBlack,
    surface = eerieBlack,
    surfaceContainerHighest = eerieBlack,

    primary = Blue80,
    primaryContainer = Blue20,
    onPrimaryContainer = Blue80,

    secondaryContainer = Blue40,
    onSecondaryContainer = Blue90,

    onBackground = LightWhite,
    onSurface = LightWhite,
)

private val LightColorScheme = lightColorScheme(
    background = antiFlashWhite,
    surface = antiFlashWhite,
    surfaceContainerHighest = antiFlashWhite,

    primary = Blue30,
    primaryContainer = Blue80,
    onPrimaryContainer = Blue10,

    secondaryContainer = Blue90,
    onSecondaryContainer = Blue10,

    onBackground = DarkGrey,
    onSurface = DarkGrey,
)

@Composable
fun TaskManagementTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
