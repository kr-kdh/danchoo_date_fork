package com.danchoo.components.ui.dialog

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun ListDialog(
    items: List<String>,
    textColor: Color = MaterialTheme.colors.onSurface,
    isDivider: Boolean = true,
    onItemSelected: (index: Int, value: String) -> Unit = { _, _ -> },
    onDismissRequest: () -> Unit = {}
) {
    Dialog(onDismissRequest = onDismissRequest) {
        ListDialogContents(
            items = items,
            textColor = textColor,
            isDivider = isDivider,
            onItemSelected = onItemSelected
        )
    }
}

@Composable
fun ListDialogContents(
    items: List<String>,
    textColor: Color,
    isDivider: Boolean = true,
    onItemSelected: (index: Int, value: String) -> Unit = { _, _ -> }
) {
    Card(modifier = Modifier.wrapContentSize()) {
        LazyColumn {
            itemsIndexed(items) { index, value ->
                Column(Modifier.width(IntrinsicSize.Min)) {
                    TextButton(
                        modifier = Modifier
                            .heightIn(max = MAX_LIST_DIALOG_HEIGHT)
                            .widthIn(max = MAX_LIST_DIALOG_WIDTH, min = MIN_LIST_DIALOG_WIDTH),
                        onClick = { onItemSelected(index, value) }
                    ) {
                        Text(
                            text = value,
                            color = textColor,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    if (isDivider) {
                        Divider(Modifier.fillMaxSize())
                    }
                }
            }
        }
    }
}

private val MIN_LIST_DIALOG_WIDTH = 200.dp
private val MAX_LIST_DIALOG_WIDTH = 300.dp
private val MAX_LIST_DIALOG_HEIGHT = 500.dp
