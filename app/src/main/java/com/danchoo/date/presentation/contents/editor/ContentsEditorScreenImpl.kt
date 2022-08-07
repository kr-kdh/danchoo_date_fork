package com.danchoo.date.presentation.contents.editor

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danchoo.category.domain.model.CategoryModel
import com.danchoo.commonutils.composition.LocalRemoteStorageLoader
import com.danchoo.components.event.OnViewEvent
import com.danchoo.components.theme.MyApplicationTheme
import com.danchoo.components.theme.titleButtonColor
import com.danchoo.components.ui.appbar.BackTopAppBar
import com.danchoo.components.ui.button.IconButton
import com.danchoo.components.ui.button.OutlinedTextButton
import com.danchoo.components.ui.button.OutlinedTextSwitchButton
import com.danchoo.components.ui.button.TagItemButton
import com.danchoo.contents.domain.model.ContentsMediaModel
import com.danchoo.date.R
import com.danchoo.date.presentation.contents.editor.ContentsEditorContract.ContentsEditorViewEvent
import com.danchoo.date.presentation.contents.editor.ContentsEditorContract.ContentsEditorViewState
import com.danchoo.glideimage.GlideImage
import com.danchoo.tags.domain.model.TagModel
import com.google.accompanist.flowlayout.FlowRow


@Composable
fun ContentsEditorScreenImpl(
    modifier: Modifier = Modifier,
    viewState: ContentsEditorViewState,
    onViewEvent: OnViewEvent = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            ContentsEditorTopBar(
                isEnableConfirm = viewState.isEnableConfirm,
                onClickBack = { onViewEvent(ContentsEditorViewEvent.OnClickBack) },
                onClickConfirm = { onViewEvent(ContentsEditorViewEvent.OnClickConfirm) }
            )
        }
    ) { it ->
        ContentsEditorLayout(
            modifier = Modifier
                .padding(it)
                .padding(MyApplicationTheme.spacing.baseLineSpacingMedium),
            onClickAddImage = {},
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
                CategorySelect(
                    category = viewState.selectedCategory,
                    onClick = {
                        onViewEvent(ContentsEditorViewEvent.OnClickCategoryList)
                    }
                )
            },
            tag = {
                ContentsTag(
                    tagList = viewState.tagList,
                    onClickAdd = {
                        onViewEvent(ContentsEditorViewEvent.OnClickAddTag)
                    },
                    onClickDelete = { tagModel ->
                        onViewEvent(ContentsEditorViewEvent.OnClickDeleteTag(tagModel))
                    }
                )
            },
            description = {
                ContentsDescription(
                    text = viewState.description,
                    onValueChange = {
                        onViewEvent(ContentsEditorViewEvent.OnDescriptionChanged(it))
                    }
                )
            },
            setting = {
                OutlinedTextSwitchButton(
                    text = stringResource(id = R.string.content_create_enable_visible),
                    checked = viewState.isVisibility,
                    onCheckedChange = {
                        onViewEvent(ContentsEditorViewEvent.OnCheckedChangedVisibility(it))
                    }
                )
            }
        )
    }
}

@Composable
private fun ContentsDescription(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .height(256.dp),
        value = text,
        label = {
            Text(text = stringResource(id = R.string.content_create_description_place_holder))
        },
        placeholder = {
            Text(text = stringResource(id = R.string.content_create_description_place_holder))
        },
        onValueChange = onValueChange
    )
}

@Composable
private fun ContentsEditorTopBar(
    modifier: Modifier = Modifier,
    isEnableConfirm: Boolean = false,
    onClickBack: () -> Unit = {},
    onClickConfirm: () -> Unit = {}
) {
    BackTopAppBar(
        modifier = modifier,
        title = { Text(text = stringResource(id = R.string.content_create_title)) },
        onClickBack = onClickBack,
        actions = {
            TextButton(
                enabled = isEnableConfirm,
                onClick = onClickConfirm,
                colors = ButtonDefaults.titleButtonColor(),
            ) {
                Text(text = stringResource(id = R.string.confirm))
            }
        }
    )
}

@Composable
private fun ContentsAddButton(
    modifier: Modifier = Modifier,
    onClickAddImage: () -> Unit
) {
    Box(
        modifier = modifier
            .size(CONTENTS_MEDIA_SIZE.dp)
            .clip(MaterialTheme.shapes.small)
            .border(
                width = MyApplicationTheme.borderWidth.borderLarge,
                color = MyApplicationTheme.colors.borderVariant,
                shape = MaterialTheme.shapes.small
            )
            .clickable { onClickAddImage() }
    ) {
        Icon(
            modifier = Modifier
                .size(MyApplicationTheme.minSize)
                .align(Alignment.Center),
            imageVector = Icons.Filled.Add,
            tint = MyApplicationTheme.colors.borderVariant,
            contentDescription = "ContentsEmptyItem_Empty_Add"
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

        GlideImage(
            modifier = Modifier.fillMaxSize(),
            data = mediaModel.thumbnailLocalPath.ifEmpty {
                LocalRemoteStorageLoader.current.getMediaUri(mediaModel.thumbnailKey)
            },
            contentScale = ContentScale.Crop
        )
    }
}


@Composable
private fun ContentsTag(
    tagList: List<TagModel> = emptyList(),
    onClickAdd: () -> Unit = {},
    onClickDelete: (TagModel) -> Unit = {},
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = MyApplicationTheme.spacing.baseLineSpacing),
            text = stringResource(id = R.string.content_create_tag_title)
        )

        IconButton(
            imageVector = Icons.Default.Add,
            tint = LocalContentColor.current.copy(ContentAlpha.medium)
        ) {
            onClickAdd()
        }
    }

    if (tagList.isEmpty()) {
        OutlinedTextButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = MyApplicationTheme.spacing.baseLineSpacingSmallest),
            text = stringResource(id = R.string.content_create_tag_empty),
            onClick = onClickAdd
        )
    } else {
        FlowRow(
            modifier = Modifier
                .padding(top = MyApplicationTheme.spacing.baseLineSpacingSmallest)
                .fillMaxWidth()
                .wrapContentSize()
                .clip(MaterialTheme.shapes.small)
                .border(
                    width = MyApplicationTheme.borderWidth.borderBase,
                    color = MyApplicationTheme.colors.border,
                    shape = MaterialTheme.shapes.small
                )
                .padding(horizontal = MyApplicationTheme.spacing.baseLineSpacingSmall),
            mainAxisSpacing = MyApplicationTheme.spacing.baseLineSpacing,
            crossAxisSpacing = MyApplicationTheme.spacing.baseLineSpacing
        ) {
            tagList.forEach { tagModel ->
                TagItemButton(
                    tagName = tagModel.tag,
                    onClickDelete = {
                        onClickDelete(tagModel)
                    }
                )
            }
        }
    }
}

@Composable
private fun CategorySelect(
    category: CategoryModel? = null,
    onClick: () -> Unit
) {
    Text(
        modifier = Modifier
            .padding(bottom = MyApplicationTheme.spacing.baseLineSpacing)
            .fillMaxWidth(),
        text = stringResource(id = R.string.category)
    )

    OutlinedTextButton(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = MyApplicationTheme.spacing.baseLineSpacingSmallest),
        text = category?.title ?: "",
        onClick = onClick
    )
}


@Composable
private fun ContentsEditorLayout(
    modifier: Modifier = Modifier,
    media: @Composable RowScope.() -> Unit,
    category: @Composable ColumnScope.() -> Unit,
    tag: @Composable ColumnScope.() -> Unit,
    description: @Composable ColumnScope.() -> Unit,
    setting: @Composable ColumnScope.() -> Unit,
    onClickAddImage: () -> Unit = {}
) {
    val horizontalScrollState = rememberScrollState()
    val verticalScrollState = rememberScrollState()
    Column(
        modifier = modifier.verticalScroll(verticalScrollState),
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    end = MyApplicationTheme.spacing.baseLineSpacingMedium
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ContentsAddButton(
                onClickAddImage = onClickAddImage
            )

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
        }

        Spacer(modifier = Modifier.padding(MyApplicationTheme.spacing.baseLineSpacing))

        tag()

        Spacer(modifier = Modifier.padding(MyApplicationTheme.spacing.baseLineSpacing))

        category()

        Spacer(modifier = Modifier.padding(MyApplicationTheme.spacing.baseLineSpacing))

        description()

        Spacer(modifier = Modifier.padding(MyApplicationTheme.spacing.baseLineSpacing))

        setting()
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

