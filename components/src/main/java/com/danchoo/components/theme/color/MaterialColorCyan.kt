package com.danchoo.components.theme.color

import androidx.compose.ui.graphics.Color
import com.danchoo.components.theme.ColorSet

enum class MaterialColorCyan(
    val main: Color, //primary, secondary
    val light: Color, // background, surface
    val dark: Color,// primaryVariant, secondaryVariant
    val text: Color // onPrimary, onSecondary, onBackground, onSurface,
) {
    Tone50(
        main = Color(0xffe0f7fa),
        light = Color(0xffffffff),
        dark = Color(0xffaec4c7),
        text = Color(0xff000000)
    ),
    Tone100(
        main = Color(0xffb2ebf2),
        light = Color(0xffe5ffff),
        dark = Color(0xff81b9bf),
        text = Color(0xff000000)
    ),
    Tone900(
        main = Color(0xff006064),
        light = Color(0xff428e92),
        dark = Color(0xff00363a),
        text = Color(0xffffffff)
    );

    fun toColorSet(): ColorSet {
        return ColorSet(main, light, dark, text)
    }
}
