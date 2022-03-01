package com.danchoo.date.presentation.home.category.editor

import android.content.res.Configuration
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danchoo.components.event.OnViewEvent
import com.danchoo.components.extension.applyAlpha80
import com.danchoo.components.theme.MyApplicationTheme
import com.danchoo.components.theme.titleButtonColor
import com.danchoo.components.ui.appbar.BackTopAppBar
import com.danchoo.components.ui.textfield.TitleTextField
import com.danchoo.date.R
import com.danchoo.date.presentation.home.category.editor.CategoryEditorContract.CategoryEditorViewEvent
import com.danchoo.date.presentation.home.category.editor.CategoryEditorContract.CategoryEditorViewState
import com.danchoo.glideimage.GlideImage

@Composable
fun CategoryEditorScreenImpl(
    modifier: Modifier = Modifier,
    state: CategoryEditorState,
    viewState: CategoryEditorViewState,
    onViewEvent: OnViewEvent = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            BackTopAppBar(
                title = { Text(text = stringResource(id = R.string.category_create)) },
                onClickBack = {
                    onViewEvent(CategoryEditorViewEvent.OnClickBack)
                },
                actions = {
                    TextButton(
                        enabled = state.isEnableConfirm(),
                        onClick = {
                            onViewEvent(CategoryEditorViewEvent.OnClickConfirm)
                        },
                        colors = ButtonDefaults.titleButtonColor(),
                    ) {
                        Text(text = stringResource(id = R.string.confirm))
                    }
                }
            )
        }
    ) {
        CategoryEditorLayout(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            coverImage = {
                AddCoverImage(uri = viewState.coverImageUri) {
                    onViewEvent(CategoryEditorViewEvent.OnClickImageChange)
                }
            },
            category = { childModifier ->
                AddTitle(
                    modifier = childModifier,
                    text = state.title.value,
                ) { title ->
                    onViewEvent(CategoryEditorViewEvent.OnTitleChanged(title))
                }
            },
            description = { childModifier ->
                AddDescription(
                    modifier = childModifier,
                    text = state.description.value
                ) { description ->
                    onViewEvent(CategoryEditorViewEvent.OnDescriptionChanged(description))
                }
            },
            setting = { childModifier ->
                AddVisibility(
                    modifier = childModifier,
                    isVisibility = state.isVisibility.value
                ) { isVisibility ->
                    onViewEvent(CategoryEditorViewEvent.OnVisibilityChanged(isVisibility))
                }

                AddChangeImage(
                    modifier = childModifier,
                ) {
                    onViewEvent(CategoryEditorViewEvent.OnClickImageChange)
                }
            }
        )
    }
}

@Composable
private fun CategoryEditorLayout(
    modifier: Modifier = Modifier,
    coverImage: @Composable LazyItemScope.(childModifier: Modifier) -> Unit,
    category: @Composable LazyItemScope.(childModifier: Modifier) -> Unit,
    description: @Composable LazyItemScope.(childModifier: Modifier) -> Unit,
    setting: @Composable LazyItemScope.(childModifier: Modifier) -> Unit
) {
    LazyColumn(modifier = modifier) {
        item {
            val childModifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = MyApplicationTheme.spacing.baseLineSpacingMedium,
                    end = MyApplicationTheme.spacing.baseLineSpacingMedium
                )

            coverImage(childModifier)
            category(childModifier)

            description(childModifier)

            Divider(
                childModifier.padding(
                    top = MyApplicationTheme.spacing.baseLineSpacingLarge,
                    bottom = MyApplicationTheme.spacing.baseLineSpacingMedium
                )
            )

            setting(childModifier)
        }
    }
}

@Composable
private fun AddCoverImage(
    modifier: Modifier = Modifier,
    uri: Uri,
    onClick: () -> Unit = {}
) {
    GlideImage(
        modifier = modifier
            .fillMaxWidth()
            .height(192.dp)
            .clickable { onClick() },
        data = if (uri != Uri.EMPTY) uri else R.drawable.the_gleaners,
        contentScale = ContentScale.Crop
    )
}

@Composable
private fun AddTitle(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit = {}
) {
    TitleTextField(
        modifier = modifier,
        value = text,
        title = stringResource(id = R.string.category_create_title),
        placeholder = stringResource(id = R.string.category_create_title_placeholder)
    ) {
        onValueChange(it)
    }
}

@Composable
private fun AddDescription(
    modifier: Modifier,
    text: String,
    onValueChange: (String) -> Unit = {}
) {
    TitleTextField(
        modifier = modifier,
        value = text,
        title = stringResource(id = R.string.category_create_description),
        placeholder = stringResource(id = R.string.category_create_description_placeholder)
    ) {
        onValueChange(it)
    }
}

@Composable
private fun AddVisibility(
    modifier: Modifier,
    isVisibility: Boolean,
    onClick: (isVisibility: Boolean) -> Unit = {}
) {
    OutlinedButton(
        modifier = modifier
            .padding(
                top = MyApplicationTheme.spacing.baseLineSpacing,
                bottom = MyApplicationTheme.spacing.baseLineSpacing
            )
            .semantics {
                contentDescription = "AddVisibility switch"
            },
        onClick = {
            onClick(!isVisibility)
        }
    ) {

        Text(
            modifier = Modifier
                .weight(1f)
                .padding(
                    top = MyApplicationTheme.spacing.baseLineSpacing,
                    bottom = MyApplicationTheme.spacing.baseLineSpacing
                ),
            text = stringResource(id = R.string.category_create_enable_visible),
            style = MyApplicationTheme.typography.subtitle1,
            color = MyApplicationTheme.colors.textPrimary.applyAlpha80()
        )

        Switch(
            modifier = Modifier.defaultMinSize(MyApplicationTheme.minSize),
            checked = isVisibility,
            onCheckedChange = {
                onClick(!isVisibility)
            }
        )
    }
}


@Composable
private fun AddChangeImage(
    modifier: Modifier,
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = modifier
            .padding(
                top = MyApplicationTheme.spacing.baseLineSpacing,
                bottom = MyApplicationTheme.spacing.baseLineSpacing
            ),
        onClick = onClick
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(
                    top = MyApplicationTheme.spacing.baseLineSpacing,
                    bottom = MyApplicationTheme.spacing.baseLineSpacing
                ),
            text = stringResource(id = R.string.category_create_change_cover),
            style = MyApplicationTheme.typography.subtitle1,
            color = MyApplicationTheme.colors.textPrimary.applyAlpha80()
        )
    }
}

@Preview("light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun CategoryEditorScreenPreview() {
    MyApplicationTheme {
        CategoryEditorScreenImpl(
            state = rememberCategoryEditorState(),
            viewState = CategoryEditorViewState()
        )
    }
}

