package com.danchoo.date.presentation.ui.components.common

import android.util.Log
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import com.danchoo.date.presentation.ui.common.extension.debounce
import com.danchoo.date.presentation.ui.theme.MainTheme
import java.util.*


sealed class FloatingButtonActionEvent {
    object Add : FloatingButtonActionEvent()
}

@Composable
fun AddFloatingActionButton(
    onClick: () -> Unit
) {
    FloatingActionButton(
        backgroundColor = MainTheme.colors.primary,
        contentColor = MainTheme.colors.textPrimary,
        onClick = onClick.debounce()
    ) {
        Icon(Icons.Filled.Add, "")
    }
}
