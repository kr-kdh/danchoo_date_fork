package com.danchoo.date.presentation.ui.components.main.editor.category

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.danchoo.components.permission.RequestPermission
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

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) {
    }

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
                    MediaSelectType.Camera -> {
                        state.isShowPermission.value = true
                    }
                    MediaSelectType.Gallery -> {}
                }
            }
        ) {
            state.isShowMenuDialog.value = false
        }
    }

    if (state.isShowPermission.value) {
        RequestPermission(
            permission = Manifest.permission.CAMERA,
            onSuccess = { launcher.launch() },
            onDenied = {},
            onRequestMoveSetting = {},
            onRequestDismiss = {
                state.isShowPermission.value = false
            }
        )
    }
}

