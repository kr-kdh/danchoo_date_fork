package com.danchoo.components.ui.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ExpandButton(
    modifier: Modifier = Modifier,
    expanded: Boolean = false,
    enable: Boolean = true,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier,
        imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
        enabled = enable,
        onClick = onClick
    )
}