package com.danchoo.components.theme.color

import androidx.compose.ui.graphics.Color
import com.danchoo.components.theme.ColorSet

enum class MaterialColorIndigo(
    val main: Color, //primary, secondary
    val light: Color, // background, surface
    val dark: Color,// primaryVariant, secondaryVariant
    val text: Color // onPrimary, onSecondary, onBackground, onSurface
) {
    Tone50(
        main = Color(0xffe8eaf6),
        light = Color(0xffffffff),
        dark = Color(0xffb6b8c3),
        text = Color(0xff000000)
    ),
    Tone100(
        main = Color(0xffc5cae9),
        light = Color(0xfff8fdff),
        dark = Color(0xff9499b7),
        text = Color(0xff000000)
    ),
    Tone200(
        main = Color(0xff9fa8da),
        light = Color(0xffd1d9ff),
        dark = Color(0xff6f79a8),
        text = Color(0xff000000)
    ),
    Tone900(
        main = Color(0xff1a237e),
        light = Color(0xff534bae),
        dark = Color(0xff000051),
        text = Color(0xffffffff)
    );

    fun toColorSet(): ColorSet {
        return ColorSet(main, light, dark, text)
    }
}
