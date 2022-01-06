package com.danchoo.date.presentation.ui.components.main.editor.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.danchoo.components.event.onViewEvent
import com.danchoo.components.extension.applyAlpha80
import com.danchoo.components.theme.MyApplicationTheme
import com.danchoo.components.ui.appbar.BackTopAppBar
import com.danchoo.components.ui.textfield.TitleTextField
import com.danchoo.date.R
import com.danchoo.date.presentation.ui.components.main.editor.category.CategoryEditorContract.CategoryEditorViewEvent
import com.danchoo.date.presentation.ui.components.main.editor.category.CategoryEditorContract.CategoryEditorViewState

@Composable
fun CategoryEditorScreenImpl(
    modifier: Modifier,
    state: CategoryEditorState,
    viewState: CategoryEditorViewState,
    onViewEvent: onViewEvent
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            BackTopAppBar(
                title = { Text(text = stringResource(id = R.string.category_create)) },
                onClickBack = {
                    onViewEvent(CategoryEditorViewEvent.OnClickBackPress)
                }
            )
        }
    ) {
        CategoryEditorContents(
            modifier = modifier
                .padding(it)
                .fillMaxSize(),
            coverImage = {
                AddCoverImage {
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
private fun CategoryEditorContents(
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
    onClick: () -> Unit = {}
) {
    Image(
        modifier = modifier
            .fillMaxWidth()
            .height(192.dp)
            .clickable { onClick() },
        painter = rememberAsyncImagePainter(
            model = R.drawable.the_gleaners
        ),
        contentDescription = null,
        alignment = Alignment.Center,
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


