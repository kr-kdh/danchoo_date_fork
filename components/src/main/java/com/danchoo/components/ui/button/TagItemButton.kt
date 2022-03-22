package com.danchoo.components.ui.button

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import com.danchoo.components.theme.MyApplicationTheme


@Composable
fun TagItemButton(
    modifier: Modifier = Modifier,
    tagName: String,
    onClick: (() -> Unit)? = null,
    onClickDelete: (() -> Unit)? = null
) {

    Box(
        modifier = modifier
            .wrapContentSize()
            .clip(RoundedCornerShape(percent = 50))
            .border(
                width = MyApplicationTheme.borderWidth.borderBase,
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(percent = 50)
            )
            .clickable {
                onClick?.invoke()
            }
    ) {

        Row(
            modifier = modifier.wrapContentSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = tagName,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            onClickDelete?.let {
                IconButton(
                    imageVector = Icons.Default.Close,
                    onClick = it
                )
            }
        }
    }
}