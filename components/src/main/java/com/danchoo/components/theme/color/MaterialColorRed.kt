package com.danchoo.components.theme.color

import androidx.compose.ui.graphics.Color
import com.danchoo.components.theme.ColorSet

enum class MaterialColorRed(
    val main: Color, //primary, secondary
    val light: Color, // background, surface
    val dark: Color,// primaryVariant, secondaryVariant
    val text: Color // onPrimary, onSecondary, onBackground, onSurface
) {
    Tone50(
        main = Color(0xffffebee),
        light = Color(0xffffffff),
        dark = Color(0xffccb9bc),
        text = Color(0xff000000)
    ),
    Tone100(
        main = Color(0xffffcdd2),
        light = Color(0xffffffff),
        dark = Color(0xffcb9ca1),
        text = Color(0xff000000)
    );

    fun toColorSet(): ColorSet {
        return ColorSet(main, light, dark, text)
    }
}
