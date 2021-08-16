package com.danchoo.date.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.intl.LocaleList.Companion.current
import java.util.concurrent.ThreadLocalRandom.current
import androidx.compose.runtime.staticCompositionLocalOf
private val DarkColorPalette = MainColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = White,
    textPrimary = darkColors().onPrimary,
    textSecondary = darkColors().onSecondary,
    isLight = false
)

private val LightColorPalette = MainColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200,
    textPrimary = lightColors().onPrimary,
    textSecondary = lightColors().onSecondary,
    background = White,
    isLight = true

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    ProvideColors(colors) {
        MaterialTheme(
            colors = colors.getColors(),
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }

}

@Stable
class MainColors(
    primary: Color,
    primaryVariant: Color,
    secondary: Color,
    background: Color,
    textPrimary: Color,
    textSecondary: Color,
    isLight: Boolean
) {
    var primary by mutableStateOf(primary)
        private set
    var primaryVariant by mutableStateOf(primaryVariant)
        private set
    var secondary by mutableStateOf(secondary)
        private set

    var textPrimary by mutableStateOf(textPrimary)
        private set
    var textSecondary by mutableStateOf(textSecondary)
        private set

    var background by mutableStateOf(background)
        private set

    var isLight by mutableStateOf(isLight)
        private set

    fun update(other: MainColors) {
        primary = other.primary
        primaryVariant = other.primaryVariant
        secondary = other.secondary
        textPrimary = other.textPrimary
        textSecondary = other.textSecondary
        background = other.background
        isLight = other.isLight
    }

    fun copy(): MainColors = MainColors(
        primary = primary,
        primaryVariant = primaryVariant,
        secondary = secondary,
        textPrimary = textPrimary,
        textSecondary = textSecondary,
        background = background,
        isLight = isLight
    )

    fun getColors(): Colors {
        val defaultColor = if (isLight) {
            lightColors()
        } else {
            darkColors()
        }

        return Colors(
            primary = primary,
            primaryVariant = primaryVariant,
            secondary = secondary,
            secondaryVariant = defaultColor.secondaryVariant,
            background = background,
            surface = defaultColor.surface,
            error = defaultColor.error,
            onPrimary = textPrimary,
            onSecondary = textSecondary,
            onBackground = defaultColor.onBackground,
            onSurface = defaultColor.onSurface,
            onError = defaultColor.onError,
            isLight = defaultColor.isLight,
        )
    }
}

@Composable
fun ProvideColors(
    colors: MainColors,
    content: @Composable () -> Unit
) {
    val colorPalette = remember {
        // Explicitly creating a new object here so we don't mutate the initial [colors]
        // provided, and overwrite the values set in it.
        colors.copy()
    }
    colorPalette.update(colors)
    CompositionLocalProvider(LocalMainColors provides colorPalette, content = content)
}

private val LocalMainColors = staticCompositionLocalOf<MainColors> {
    error("No JetsnackColorPalette provided")
}

object MainTheme {
    val colors: MainColors
        @Composable
        get() = LocalMainColors.current
}

