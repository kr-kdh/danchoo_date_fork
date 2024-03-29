package com.danchoo.components.ui.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    tint: Color? = null,
    onClick: () -> Unit
) {
    val contentTint = tint ?: run {
        val contentAlpha = if (enabled) LocalContentAlpha.current else ContentAlpha.disabled
        LocalContentColor.current.copy(alpha = contentAlpha)
    }

    IconButton(
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        onClick = onClick
    ) {
        Icon(
            imageVector = imageVector,
            tint = contentTint,
            contentDescription = null
        )
    }
}

@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    painter: Painter,
    tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        onClick = onClick
    ) {
        Icon(
            painter = painter,
            tint = tint,
            contentDescription = null
        )
    }
}