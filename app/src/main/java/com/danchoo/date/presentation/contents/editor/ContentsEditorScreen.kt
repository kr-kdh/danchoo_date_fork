package com.danchoo.date.presentation.contents.editor

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.danchoo.category.domain.model.CategoryModel
import com.danchoo.components.ui.dialog.ListDialog
import com.danchoo.date.presentation.contents.editor.ContentsEditorContract.ContentsEditorEvent
import com.danchoo.date.presentation.contents.editor.ContentsEditorContract.ContentsEditorViewEvent


@Composable
fun ContentsEditorScreen(
    modifier: Modifier = Modifier,
    viewModel: ContentsEditViewModel = hiltViewModel(),
    onClickBack: () -> Unit = {},
    onClickTag: () -> Unit = {}
) {
    val viewState by viewModel.viewState

    ContentsEditorScreenImpl(
        modifier = modifier,
        viewState = viewState,
    ) { viewEvent ->
        when (viewEvent) {
            is ContentsEditorViewEvent.OnClickBack -> onClickBack()
            is ContentsEditorViewEvent.OnClickCategoryList -> {
                viewModel.setEvent(ContentsEditorEvent.ShowCategorySelectDialog)
            }
            is ContentsEditorViewEvent.OnCheckedChangedVisibility -> {
                viewModel.setEvent(ContentsEditorEvent.OnCheckedChangedVisibility(viewEvent.checked))
            }
            is ContentsEditorViewEvent.OnDescriptionChanged -> {
                viewModel.setEvent(ContentsEditorEvent.OnDescriptionChanged(viewEvent.description))
            }
            is ContentsEditorViewEvent.OnClickAddTag -> {
                onClickTag()
            }
            else -> Unit
        }
    }

    if (viewState.isShowCategorySelectDialog) {
        CategorySelectDialog(
            categoryList = viewState.categoryList,
            onSelectCategory = {
                viewModel.setEvent(ContentsEditorEvent.OnSelectCategory(it))
                viewModel.setEvent(ContentsEditorEvent.HideCategorySelectDialog)
            },
            onDismissRequest = {
                viewModel.setEvent(ContentsEditorEvent.HideCategorySelectDialog)
            }
        )
    }
}

@Composable
fun CategorySelectDialog(
    categoryList: List<CategoryModel>,
    onSelectCategory: (CategoryModel) -> Unit,
    onDismissRequest: () -> Unit = {}
) {
    ListDialog(
        items = categoryList,
        onDismissRequest = onDismissRequest,
        onItemSelected = onSelectCategory,
    ) { categoryModel ->
        Text(text = categoryModel.title)
    }
}

