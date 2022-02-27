package com.danchoo.date.presentation.contents.editor

import android.content.res.Configuration
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.danchoo.components.event.OnViewEvent
import com.danchoo.components.theme.MyApplicationTheme
import com.danchoo.components.ui.appbar.BackTopAppBar
import com.danchoo.date.R
import com.danchoo.date.presentation.contents.ContentsContract


@Composable
fun ContentsEditorScreenImpl(
    modifier: Modifier = Modifier,
    onViewEvent: OnViewEvent = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            BackTopAppBar(
                title = { Text(text = stringResource(id = R.string.category_create)) },
                onClickBack = {
                    onViewEvent(ContentsContract.ContentsEditorViewEvent.OnClickBack)
                },
                actions = {
                }
            )
        }
    ) {

        ContentsEditorContents(
            modifier = Modifier.padding(it),
            image = {


            },
            category = {

            },
            description = {

            },
            setting = {

            }
        )
    }
}

@Composable
private fun ContentsEditorContents(
    modifier: Modifier = Modifier,
    image: @Composable RowScope.() -> Unit,
    category: @Composable () -> Unit,
    description: @Composable () -> Unit,
    setting: @Composable () -> Unit
) {
    val scrollState = rememberScrollState()
    val verticalScrollState = rememberScrollState()
    Column(modifier = modifier.verticalScroll(scrollState)) {

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
                    .horizontalScroll(verticalScrollState)
                    .weight(1f)
                    .padding(
                        start = MyApplicationTheme.spacing.baseLineSpacingMedium,
                        end = MyApplicationTheme.spacing.baseLineSpacingMedium
                    )
            ) {
                image()
            }

            IconButton(
                onClick = { }
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


@Preview("light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ContentsEditorScreenPreview() {
    MyApplicationTheme {
        ContentsEditorScreenImpl()
    }
}

