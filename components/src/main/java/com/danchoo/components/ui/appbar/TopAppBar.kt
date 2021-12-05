package com.danchoo.components.ui.appbar

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.danchoo.components.event.onViewEvent
import com.danchoo.components.theme.MainTheme
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
    TopAppBar(modifier = modifier, contentPadding = PaddingValues()) {
        when (type) {
            TopAppbarType.Title -> TopAppBarTitle(title = title)
            TopAppbarType.Back -> TopAppBarBack(title = title, onViewEvent = onViewEvent)
            TopAppbarType.Search -> TopAppBarTitle(title = title)
            TopAppbarType.More -> TopAppBarTitle(title = title)
            TopAppbarType.Edit -> TopAppBarTitle(title = title)
        }
    }
}

@Composable
private fun RowScope.TopAppBarTitle(
    modifier: Modifier = Modifier,
    title: String
) {
    Text(
        modifier = modifier
            .padding(
                start = MainTheme.spacing.baseLineSpacingMedium,
                end = MainTheme.spacing.baseLineSpacingMedium
            ),
        type = TextType.Title1, text = title
    )
}

@Composable
private fun RowScope.TopAppBarBack(
    modifier: Modifier = Modifier,
    title: String,
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

    Text(
        modifier = modifier.padding(end = MainTheme.spacing.baseLineSpacing),
        type = TextType.Title1, text = title
    )
}