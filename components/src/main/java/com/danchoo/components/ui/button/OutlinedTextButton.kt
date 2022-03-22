package com.danchoo.components.ui.button

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.danchoo.components.extension.applyAlpha80
import com.danchoo.components.theme.MyApplicationTheme

@Composable
fun OutlinedTextButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = modifier.defaultMinSize(MyApplicationTheme.minSize),
        onClick = onClick
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(
                    top = MyApplicationTheme.spacing.baseLineSpacing,
                    bottom = MyApplicationTheme.spacing.baseLineSpacing
                ),
            text = text,
            style = MyApplicationTheme.typography.subtitle1,
            color = MyApplicationTheme.colors.textPrimary.applyAlpha80()
        )
    }
}