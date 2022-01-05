package com.danchoo.components.ui.button

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import com.danchoo.components.theme.MyApplicationTheme

@Composable
fun AddFloatingActionButton(
    onClick: () -> Unit
) {
    FloatingActionButton(
        backgroundColor = MyApplicationTheme.colors.primary,
        contentColor = MyApplicationTheme.colors.textPrimary,
        onClick = onClick
    ) {
        Icon(Icons.Filled.Add, "")
    }
}
