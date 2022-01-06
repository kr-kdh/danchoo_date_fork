package com.danchoo.date.presentation.ui.components.main.editor.category

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.danchoo.date.presentation.ui.components.common.dialog.MediaSelectDialog
import com.danchoo.date.presentation.ui.components.common.dialog.MediaSelectType
import com.danchoo.date.presentation.ui.components.main.editor.category.CategoryEditorContract.CategoryEditorViewEvent
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@Composable
fun CategoryEditorScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: CategoryEditorViewModel = hiltViewModel()
) {

    val viewState = viewModel.viewState.value
    val state = rememberCategoryEditorState(navController)

    LaunchedEffect(key1 = Unit) {
        viewModel.sideEffect
            .onEach { }
            .collect()
    }

    CategoryEditorScreenImpl(
        modifier = modifier,
        state = state,
        viewState = viewState
    ) {
        when (it) {
            is CategoryEditorViewEvent.OnClickBackPress -> state.popBackStack()
            is CategoryEditorViewEvent.OnTitleChanged -> {
                state.title.value = it.title
            }
            is CategoryEditorViewEvent.OnDescriptionChanged -> {
                state.description.value = it.description
            }
            is CategoryEditorViewEvent.OnVisibilityChanged -> {
                state.isVisibility.value = it.visibility
            }
            is CategoryEditorViewEvent.OnClickImageChange -> {
                state.isShowMenuDialog.value = true
            }
        }
    }

    if (state.isShowMenuDialog.value) {
        MediaSelectDialog(
            onItemSelected = {
                when (it) {
                    MediaSelectType.Camera -> {}
                    MediaSelectType.Gallery -> {}
                }
            }
        ) {
            state.isShowMenuDialog.value = false
        }
    }
}