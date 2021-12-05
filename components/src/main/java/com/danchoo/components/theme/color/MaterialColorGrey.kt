package com.danchoo.components.theme.color

import androidx.compose.ui.graphics.Color
import com.danchoo.components.theme.ColorSet

enum class MaterialColorGrey(
    val main: Color, //primary, secondary
    val light: Color, // background, surface
    val dark: Color,// primaryVariant, secondaryVariant
    val text: Color, // onPrimary, onSecondary, onBackground, onSurface
    val border: Color // border
) {
    Tone50(
        main = Color(0xfffafafa),
        light = Color(0xffffffff),
        dark = Color(0xffc7c7c7),
        text = Color(0xff000000),
        border = Color(0xffefefef)
    ),
    Tone100(
        main = Color(0xfff5f5f5),
        light = Color(0xffffffff),
        dark = Color(0xffc2c2c2),
        text = Color(0xff000000),
        border = Color(0xffefefef)
    ),
    Tone900(
        main = Color(0xff212121),
        light = Color(0xff484848),
        dark = Color(0xff000000),
        text = Color(0xffffffff),
        border = Color(0xffefefef)
    );

    fun toColorSet(): ColorSet {
        return ColorSet(main, light, dark, text, border)
    }
}
