package com.danchoo.components.ui.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import com.danchoo.components.extension.applyAlpha50
import com.danchoo.components.extension.applyAlpha80
import com.danchoo.components.theme.MainTheme

@Composable
fun Text(
    modifier: Modifier = Modifier,
    type: TextType,
    text: String,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
) {

    androidx.compose.material.Text(
        modifier = modifier,
        text = text,
        maxLines = getMaxLine(type, maxLines),
        style = getTextStyle(type),
        overflow = TextOverflow.Ellipsis,
        color = getTextColor(type),
        onTextLayout = onTextLayout
    )
}

@Composable
private fun getMaxLine(type: TextType, maxLines: Int): Int {
    return when (type) {
        TextType.Title1,
        TextType.Title1Bold,
        TextType.Title2,
        TextType.Title2Bold -> if (maxLines == Int.MAX_VALUE) 1 else maxLines

        TextType.Description1,
        TextType.Description2 -> maxLines

        TextType.Label -> 1
        TextType.PlaceHolder -> maxLines
    }
}

@Composable
private fun getTextStyle(type: TextType): TextStyle {
    return when (type) {
        TextType.Title1 -> MainTheme.typography.title1
        TextType.Title1Bold -> MainTheme.typography.title1Bold
        TextType.Title2 -> MainTheme.typography.title2
        TextType.Title2Bold -> MainTheme.typography.title2Bold
        TextType.Description1 -> MainTheme.typography.body1
        TextType.Description2 -> MainTheme.typography.body2
        TextType.Label -> MainTheme.typography.body1
        TextType.PlaceHolder -> MainTheme.typography.body1
    }
}

@Composable
private fun getTextColor(type: TextType): Color {
    return when (type) {
        TextType.Title1 -> MainTheme.colors.textPrimary
        TextType.Title1Bold -> MainTheme.colors.textPrimary
        TextType.Title2 -> MainTheme.colors.textPrimary
        TextType.Title2Bold -> MainTheme.colors.textPrimary
        TextType.Description1 -> MainTheme.colors.textPrimary.applyAlpha80()
        TextType.Description2 -> MainTheme.colors.textPrimary.applyAlpha80()
        TextType.Label -> MainTheme.colors.textPrimary.applyAlpha50()
        TextType.PlaceHolder -> MainTheme.colors.primary.applyAlpha50()
    }
}

enum class TextType {
    Title1,
    Title1Bold,
    Title2,
    Title2Bold,

    Description1,
    Description2,

    Label,
    PlaceHolder
}
