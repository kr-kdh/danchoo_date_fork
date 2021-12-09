package com.danchoo.components.ui.appbar

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.danchoo.components.event.onViewEvent
import com.danchoo.components.ui.appbar.AppBarConstants.AppBarEvent
import com.danchoo.components.ui.text.Text
import com.danchoo.components.ui.text.TextType


/**
 * height = 56.dp
 *
 *
 */
@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    type: TopAppbarType,
    title: String,
    onViewEvent: onViewEvent = {}
) {
    TopAppBar(modifier = modifier,
        navigationIcon = when (type) {
            TopAppbarType.Title -> null
            TopAppbarType.Back -> {
                { TopAppBarBack(onViewEvent = onViewEvent) }
            }
            TopAppbarType.Search -> {
                { TopAppBarBack(onViewEvent = onViewEvent) }
            }
            TopAppbarType.More -> {
                { TopAppBarBack(onViewEvent = onViewEvent) }
            }
            TopAppbarType.Edit -> {
                { TopAppBarBack(onViewEvent = onViewEvent) }
            }
        }, actions = {

        },
        title = {
            TopAppBarTitle(title = title)
        })
}

@Composable
private fun TopAppBarTitle(
    modifier: Modifier = Modifier,
    title: String
) {
    Text(
        modifier = modifier,
        type = TextType.Title1,
        text = title
    )
}

@Composable
private fun TopAppBarBack(
    modifier: Modifier = Modifier,
    onViewEvent: onViewEvent
) {
    IconButton(modifier = modifier,
        onClick = { onViewEvent(AppBarEvent.Back) }
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = null
        )
    }
}