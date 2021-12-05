package com.danchoo.components.ui.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.style.TextOverflow
import com.danchoo.components.extension.applyAlpha80
import com.danchoo.components.theme.MainTheme


enum class TextType {
    Title1,
    Title1Bold,
    Title2,
    Title2Bold,

    Description,
    Description1
}

@Composable
fun Text(
    modifier: Modifier = Modifier,
    type: TextType,
    text: String,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
) {

    when (type) {
        TextType.Title1 -> TextTitle1(modifier, text, maxLines, onTextLayout)
        TextType.Title1Bold -> TextTitle1(modifier, text, maxLines, onTextLayout)
        TextType.Title2 -> TextTitle1(modifier, text, maxLines, onTextLayout)
        TextType.Title2Bold -> TextTitle1(modifier, text, maxLines, onTextLayout)
        TextType.Description -> TextDescription(modifier, text, maxLines, onTextLayout)
        TextType.Description1 -> TextTitle1(modifier, text, maxLines, onTextLayout)
    }
}

@Composable
fun TextTitle1(
    modifier: Modifier = Modifier,
    text: String,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
) {
    androidx.compose.material.Text(
        modifier = modifier,
        text = text,
        maxLines = if (maxLines == Int.MAX_VALUE) 1 else maxLines,
        style = MainTheme.typography.title1Bold,
        overflow = TextOverflow.Ellipsis,
        color = MainTheme.colors.textPrimary,
        onTextLayout = onTextLayout
    )
}

@Composable
fun TextDescription(
    modifier: Modifier = Modifier,
    text: String,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
) {
    androidx.compose.material.Text(
        modifier = modifier,
        text = text,
        style = MainTheme.typography.body1,
        maxLines = if (maxLines == Int.MAX_VALUE) 1 else maxLines,
        overflow = TextOverflow.Ellipsis,
        color = MainTheme.colors.textPrimary.applyAlpha80(),
        onTextLayout = onTextLayout
    )
}