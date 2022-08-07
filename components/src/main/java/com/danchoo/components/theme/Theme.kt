package com.danchoo.components.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.danchoo.components.theme.color.MaterialColorGrey
import com.danchoo.components.theme.color.MaterialColorIndigo
import com.danchoo.components.theme.color.MaterialColorRed

data class ColorSet(
    val main: Color, //primary, secondary
    val light: Color, // background, surface
    val dark: Color,// primaryVariant, secondaryVariant
    val text: Color // onPrimary, onSecondary, onBackground, onSurface
)

object CustomTheme {
    val Dark: ColorPalette =
        createColorPalette(
            primary = MaterialColorGrey.Tone900.toColorSet(),
            secondary = MaterialColorGrey.Tone900.toColorSet(),
            false
        )


    val PinkIndigo: ColorPalette =
        createColorPalette(
            primary = MaterialColorRed.Tone50.toColorSet(),
            secondary = MaterialColorIndigo.Tone50.toColorSet(),
            true
        )

    val Indigo: ColorPalette =
        createColorPalette(
            primary = MaterialColorIndigo.Tone100.toColorSet(),
            secondary = MaterialColorIndigo.Tone100.toColorSet(),
            true
        )
}

private fun createColorPalette(
    primary: ColorSet,
    secondary: ColorSet,
    isLight: Boolean
): ColorPalette {
    return ColorPalette(
        primary = primary.main,
        primaryVariant = primary.dark,
        secondary = secondary.main,
        secondaryVariant = secondary.dark,
        background = primary.light,
        textPrimary = primary.text,
        textSecondary = secondary.text,
        border = if (isLight) primary.text.copy(alpha = 0.12f) else Color.White.copy(alpha = 0.12f),
        isLight = isLight
    )
}

object MyApplicationTheme {
    val colors: ColorPalette
        @Composable
        @ReadOnlyComposable
        get() = LocalMainColors.current

    val spacing: Spacing
        @Composable
        @ReadOnlyComposable
        get() = Spacing

    val borderWidth: BorderWidth
        @Composable
        @ReadOnlyComposable
        get() = BorderWidth

    val typography: MyTypography
        @Composable
        @ReadOnlyComposable
        get() = MyTypography

    /**
     * Icon, Item min size
     */
    val minSize: Dp = 56.dp

    val shapeSize: ShapeSize
        @Composable
        @ReadOnlyComposable
        get() = ShapeSize
}


@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    customTheme: ColorPalette = CustomTheme.Indigo,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        CustomTheme.Dark
    } else {
        customTheme
    }

    ProvideColors(colors) {
        MaterialTheme(
            colors = colors.getColors(),
            typography = MaterialTheme.typography,
            shapes = Shapes,
            content = content
        )
    }
}

@Stable
class ColorPalette(
    primary: Color,
    primaryVariant: Color,
    secondary: Color,
    secondaryVariant: Color,
    background: Color,
    textPrimary: Color,
    textSecondary: Color,
    border: Color,
    isLight: Boolean
) {
    var primary by mutableStateOf(primary)
        private set

    var primaryVariant by mutableStateOf(primaryVariant)
        private set

    var secondary by mutableStateOf(secondary)
        private set

    var secondaryVariant by mutableStateOf(secondaryVariant)
        private set

    var textPrimary by mutableStateOf(textPrimary)
        private set

    var textSecondary by mutableStateOf(textSecondary)
        private set

    var background by mutableStateOf(background)
        private set

    var border by mutableStateOf(border)

    var borderVariant by mutableStateOf(primary)

    var isLight by mutableStateOf(isLight)
        private set


    fun update(other: ColorPalette) {
        primary = other.primary
        primaryVariant = other.primaryVariant
        secondary = other.secondary
        secondaryVariant = other.secondaryVariant
        textPrimary = other.textPrimary
        textSecondary = other.textSecondary
        background = other.background
        isLight = other.isLight
    }

    fun copy(): ColorPalette = ColorPalette(
        primary = primary,
        primaryVariant = primaryVariant,
        secondary = secondary,
        secondaryVariant = secondaryVariant,
        textPrimary = textPrimary,
        textSecondary = textSecondary,
        background = background,
        border = border,
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
            secondaryVariant = secondaryVariant,
            background = background,
            surface = background,
            error = defaultColor.error,
            onPrimary = textPrimary,
            onSecondary = textSecondary,
            onBackground = textSecondary,
            onSurface = textPrimary,
            onError = defaultColor.onError,
            isLight = isLight,
        )
    }
}

@Composable
fun ProvideColors(
    colors: ColorPalette,
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

private val LocalMainColors = staticCompositionLocalOf<ColorPalette> {
    error("No JetsnackColorPalette provided")
}


