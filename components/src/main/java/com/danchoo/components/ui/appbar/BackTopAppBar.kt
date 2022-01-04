package com.danchoo.components.ui.appbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.danchoo.components.theme.MyTypography
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
        actions = actions,
        title = {
            ProvideTextStyle(value = MyTypography.title1) {
                title()
            }
        })
}