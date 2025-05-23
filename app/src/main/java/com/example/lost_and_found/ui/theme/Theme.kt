package com.example.lost_and_found.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
//    primary = Purple80,
//    secondary = PurpleGrey80,
//    tertiary = Pink80
    primary = teal40,       // Mint Green (fresh, modern)
    onPrimary = Color.White,

    secondary = red40,     // Soft Red (for alerts or accents)
    onSecondary = Color.White,

    tertiary = mint40,      // Deep Teal (strong contrast)
    onTertiary = Color.White,
)

private val LightColorScheme = lightColorScheme(
//    primary = Purple40,
//    secondary = PurpleGrey40,
//    tertiary = Pink40

    primary =Color(0xFF1A535C) ,       // Mint Green (fresh, modern)
    onPrimary = Color.White,

    secondary = Color(0xFFFF6B6B),     // Soft Red (for alerts or accents)
    onSecondary = Color.White,

    tertiary = Color(0xFF4ECDC4),      // Deep Teal (strong contrast)
    onTertiary = Color.White,
    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)
//val startGradientColor = Color(0xFF1e88e5)
//
//val endGradientColor = Color(0xFF005cb2)
//
//val gStartGradientColor = Color(0xFF013B6E)
//val gEndGradientColor = Color(0xFF2189EB)

// For primary gradients (mint theme)
val startGradientColor = Color(0xFF4ECDC4)   // Mint Green
val endGradientColor = Color(0xFF1A535C)     // Deep Teal

// For alternate gradients (soft coral contrast)
val gStartGradientColor = Color(0xFFFFA69E)  // Soft Coral Pink
val gEndGradientColor = Color(0xFFFF6B6B)    // Bold Coral Red

@Composable
fun Lost_and_foundTheme(
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