package com.danchoo.components.theme

import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val White = Color.White
val Black = Color.Black

@Composable
fun ButtonDefaults.titleButtonColor() = ButtonDefaults.textButtonColors(
    contentColor = MaterialTheme.colors.onSurface,
)


