package com.danchoo.components.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

// Set of Material typography styles to start with
object MyTypography {
    val title1: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography.h5


    private var _title1Bold: TextStyle? = null
    val title1Bold: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = _title1Bold ?: kotlin.run {
            title1.copy(
                fontWeight = FontWeight.Bold
            ).apply {
                _title1Bold = this
            }
        }

    val title2: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography.h6

    private var _title2Bold: TextStyle? = null
    val title2Bold: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = _title2Bold ?: kotlin.run {
            title2.copy(
                fontWeight = FontWeight.Bold
            ).apply {
                _title2Bold = this
            }
        }

    val body1: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography.body1

    val body2: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography.body2

    val button: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography.button

    val subtitle1: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography.subtitle1

    val subtitle2: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography.subtitle2
}