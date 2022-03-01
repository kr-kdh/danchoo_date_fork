package com.danchoo.date.presentation.contents.editor

import android.content.res.Configuration
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danchoo.components.event.OnViewEvent
import com.danchoo.components.theme.MyApplicationTheme
import com.danchoo.components.theme.titleButtonColor
import com.danchoo.components.ui.appbar.BackTopAppBar
import com.danchoo.components.ui.button.IconButton
import com.danchoo.contents.domain.model.ContentsMediaModel
import com.danchoo.date.R
import com.danchoo.date.presentation.contents.editor.ContentsEditorContract.ContentsEditorViewEvent
import com.danchoo.date.presentation.contents.editor.ContentsEditorContract.ContentsEditorViewState
import com.danchoo.glideimage.GlideImage


@Composable
fun ContentsEditorScreenImpl(
    modifier: Modifier = Modifier,
    viewState: ContentsEditorViewState,
    onViewEvent: OnViewEvent = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            BackTopAppBar(
                title = { Text(text = stringResource(id = R.string.category_create)) },
                onClickBack = {
                    onViewEvent(ContentsEditorViewEvent.OnClickBack)
                },
                actions = {
                    TextButton(
                        enabled = viewState.isEnableConfirm,
                        onClick = {
                            onViewEvent(ContentsEditorViewEvent.OnClickConfirm)
                        },
                        colors = ButtonDefaults.titleButtonColor(),
                    ) {
                        Text(text = stringResource(id = R.string.confirm))
                    }
                }
            )
        }
    ) {
        ContentsEditorLayout(
            modifier = Modifier.padding(it),
            media = {
                viewState.mediaList.forEach { mediaModel ->
                    ContentsMediaListItem(
                        mediaModel = mediaModel,
                        onClickDelete = {
                            onViewEvent(ContentsEditorViewEvent.OnClickDeleteMedia(mediaModel))
                        }
                    )
                }
            },
            category = {
                CategorySelect()
            },
            description = {

            },
            setting = {

            }
        )
    }
}

@Composable
private fun ContentsMediaListItem(
    modifier: Modifier = Modifier,
    mediaModel: ContentsMediaModel,
    onClickDelete: () -> Unit
) {
    Box(
        modifier = modifier.size(CONTENTS_MEDIA_SIZE.dp)
    ) {
        IconButton(
            modifier = Modifier
                .size(MyApplicationTheme.minSize)
                .align(Alignment.TopEnd),
            imageVector = Icons.Filled.Close,
            onClick = onClickDelete
        )

        GlideImage(data = mediaModel)
    }
}

@Composable
private fun ColumnScope.CategorySelect() {

}

@Composable
private fun ContentsEditorLayout(
    modifier: Modifier = Modifier,
    media: @Composable RowScope.() -> Unit,
    category: @Composable ColumnScope.() -> Unit,
    description: @Composable ColumnScope.() -> Unit,
    setting: @Composable ColumnScope.() -> Unit,
    onClickAddImage: () -> Unit = {}
) {
    val horizontalScrollState = rememberScrollState()
    val verticalScrollState = rememberScrollState()
    Column(modifier = modifier.verticalScroll(verticalScrollState)) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    end = MyApplicationTheme.spacing.baseLineSpacingMedium
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .horizontalScroll(horizontalScrollState)
                    .weight(1f)
                    .padding(
                        start = MyApplicationTheme.spacing.baseLineSpacingMedium,
                        end = MyApplicationTheme.spacing.baseLineSpacingMedium
                    )
            ) {
                media()
            }

            IconButton(
                onClick = { onClickAddImage() }
            ) {
                Icon(
                    modifier = Modifier.clip(CircleShape),
                    painter = rememberVectorPainter(image = Icons.Default.Add),
                    contentDescription = null
                )
            }

        }

        Column(
            modifier = Modifier.padding(
                start = MyApplicationTheme.spacing.baseLineSpacingMedium,
                end = MyApplicationTheme.spacing.baseLineSpacingMedium
            )
        ) {
            category()

            description()

            setting()
        }
    }
}

private const val CONTENTS_MEDIA_SIZE = 96

@Preview("light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ContentsEditorScreenPreview() {
    MyApplicationTheme {
        ContentsEditorScreenImpl(
            viewState = ContentsEditorViewState()
        )
    }
}

