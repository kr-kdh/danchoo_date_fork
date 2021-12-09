package com.danchoo.date.presentation.ui.components.main.editor.category

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.danchoo.date.presentation.ui.components.main.editor.category.CategoryEditorContract.CategoryEditorViewEvent
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@Composable
fun CategoryEditorDestination(
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

    CategoryEditorScreen(
        modifier = modifier,
        state = state,
        viewState = viewState
    ) {
        when (it) {
            is CategoryEditorViewEvent.TitleChanged -> {
                state.titleTextFieldValue.value = it.textFieldValue
            }
            is CategoryEditorViewEvent.DescriptionChanged -> {
                state.descriptionTextFieldValue.value = it.textFieldValue
            }
            is CategoryEditorViewEvent.VisibilityChanged -> {
                state.isVisibility.value = it.visibility
            }
        }
    }
}