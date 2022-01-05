package com.danchoo.date.presentation.ui.components.main.editor.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.danchoo.components.event.onViewEvent
import com.danchoo.components.extension.applyAlpha80
import com.danchoo.components.theme.MainTheme
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
                title = {
                    Text(text = stringResource(id = R.string.category_create))
                }
            )
        }
    ) {
        CategoryEditorContents(
            modifier = modifier
                .padding(it)
                .fillMaxSize(),
            category = { childModifier ->
                AddCoverImage(
                    modifier = childModifier,
                    onViewEvent = onViewEvent
                )

                AddTitle(
                    modifier = childModifier,
                    textFieldValue = state.titleTextFieldValue.value,
                    onViewEvent = onViewEvent
                )
            },
            description = { childModifier ->
                AddDescription(
                    modifier = childModifier,
                    textFieldValue = state.descriptionTextFieldValue.value,
                    onViewEvent = onViewEvent
                )
            },
            setting = { childModifier ->
                AddVisibility(
                    modifier = childModifier,
                    isVisibility = state.isVisibility.value,
                    onViewEvent = onViewEvent
                )

                AddChangeImage(
                    modifier = childModifier,
                    onViewEvent = onViewEvent
                )
            }
        )
    }
}

@Composable
private fun CategoryEditorContents(
    modifier: Modifier = Modifier,
    category: @Composable LazyItemScope.(childModifier: Modifier) -> Unit,
    description: @Composable LazyItemScope.(childModifier: Modifier) -> Unit,
    setting: @Composable LazyItemScope.(childModifier: Modifier) -> Unit
) {
    LazyColumn(modifier = modifier) {
        item {
            val childModifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = MainTheme.spacing.baseLineSpacingMedium,
                    end = MainTheme.spacing.baseLineSpacingMedium
                )

            category(childModifier)

            description(childModifier)

            Divider(
                childModifier.padding(
                    top = MainTheme.spacing.baseLineSpacingLarge,
                    bottom = MainTheme.spacing.baseLineSpacingMedium
                )
            )

            setting(childModifier)
        }
    }
}

@Composable
private fun AddCoverImage(
    modifier: Modifier,
    onViewEvent: onViewEvent
) {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(192.dp),
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
    textFieldValue: TextFieldValue,
    onViewEvent: onViewEvent
) {
    TitleTextField(
        modifier = modifier,
        value = textFieldValue.text,
        title = stringResource(id = R.string.category_create_title),
        placeholder = stringResource(id = R.string.category_create_title_placeholder)
    ) {
//        onViewEvent(CategoryEditorViewEvent.TitleChanged(it))
    }
}

@Composable
private fun AddDescription(
    modifier: Modifier,
    textFieldValue: TextFieldValue,
    onViewEvent: onViewEvent
) {
    TitleTextField(
        modifier = modifier,
        value = textFieldValue.text,
        title = stringResource(id = R.string.category_create_description),
        placeholder = stringResource(id = R.string.category_create_description_placeholder)
    ) {
//        onViewEvent(CategoryEditorViewEvent.DescriptionChanged(it))
    }
}

@Composable
private fun AddVisibility(
    modifier: Modifier,
    isVisibility: Boolean,
    onViewEvent: onViewEvent
) {
    OutlinedButton(
        modifier = modifier
            .padding(
                top = MainTheme.spacing.baseLineSpacing,
                bottom = MainTheme.spacing.baseLineSpacing
            ),
        onClick = {}
    ) {

        Text(
            modifier = Modifier
                .weight(1f)
                .padding(
                    top = MainTheme.spacing.baseLineSpacing,
                    bottom = MainTheme.spacing.baseLineSpacing
                ),
            text = stringResource(id = R.string.category_create_enable_visible),
            style = MainTheme.typography.subtitle1,
            color = MainTheme.colors.textPrimary.applyAlpha80()
        )

        Switch(
            modifier = Modifier
                .defaultMinSize(MainTheme.minSize)
                .padding(
                    top = MainTheme.spacing.baseLineSpacing,
                    bottom = MainTheme.spacing.baseLineSpacing
                ),
            checked = isVisibility,
            onCheckedChange = {
                onViewEvent(CategoryEditorViewEvent.VisibilityChanged(it))
            }
        )
    }
}


@Composable
private fun AddChangeImage(
    modifier: Modifier,
    onViewEvent: onViewEvent
) {

    OutlinedButton(
        modifier = modifier
            .padding(
                top = MainTheme.spacing.baseLineSpacing,
                bottom = MainTheme.spacing.baseLineSpacing
            ),
        onClick = {}
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(
                    top = MainTheme.spacing.baseLineSpacing,
                    bottom = MainTheme.spacing.baseLineSpacing
                ),
            text = stringResource(id = R.string.category_create_change_cover),
            style = MainTheme.typography.subtitle1,
            color = MainTheme.colors.textPrimary.applyAlpha80()
        )
    }
}


