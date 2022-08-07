package com.danchoo.components.ui.appbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.danchoo.components.ui.button.IconButton


/**
 * height = 56.dp
 *
 *
 */
@Composable
fun BackTopAppBar(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    onClickBack: () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor)
) {
    TopAppBar(
        modifier = modifier,
        contentColor = contentColor,
        navigationIcon = {
            IconButton(
                imageVector = Icons.Filled.ArrowBack,
                onClick = onClickBack
            )
        },
        title = {
            CompositionLocalProvider(
                LocalContentAlpha provides ContentAlpha.medium,
                LocalContentColor provides Color.Red
            ) {
                ProvideTextStyle(value = MaterialTheme.typography.subtitle1) {
                    title()
                }
            }
            
        },
        actions = {
            ProvideTextStyle(value = MaterialTheme.typography.subtitle2) {
                actions()
            }
        }
    )
}