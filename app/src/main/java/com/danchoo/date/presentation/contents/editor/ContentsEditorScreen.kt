package com.danchoo.date.presentation.contents.editor

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.danchoo.category.domain.model.CategoryModel
import com.danchoo.components.ui.dialog.ListDialog
import com.danchoo.date.presentation.contents.editor.ContentsEditorContract.ContentsEditorIntent
import com.danchoo.date.presentation.contents.editor.ContentsEditorContract.ContentsEditorViewEvent


@Composable
fun ContentsEditorScreen(
    modifier: Modifier = Modifier,
    viewModel: ContentsEditViewModel = hiltViewModel(),
    onClickBack: () -> Unit = {}
) {
    val viewState by viewModel.viewState

    ContentsEditorScreenImpl(
        modifier = modifier,
        viewState = viewState,
    ) { viewEvent ->
        when (viewEvent) {
            is ContentsEditorViewEvent.OnClickBack -> onClickBack()
            is ContentsEditorViewEvent.OnClickCategoryList -> {
                viewModel.setEvent(ContentsEditorIntent.ShowCategorySelectDialog)
            }
            is ContentsEditorViewEvent.OnCheckedChangedVisibility -> {
                viewModel.setEvent(ContentsEditorIntent.OnCheckedChangedVisibility(viewEvent.checked))
            }
            else -> Unit
        }
    }

    if (viewState.isShowCategorySelectDialog) {
        CategorySelectDialog(
            categoryList = viewState.categoryList,
            onSelectCategory = {
                viewModel.setEvent(ContentsEditorIntent.OnSelectCategory(it))
                viewModel.setEvent(ContentsEditorIntent.HideCategorySelectDialog)
            },
            onDismissRequest = {
                viewModel.setEvent(ContentsEditorIntent.HideCategorySelectDialog)
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

