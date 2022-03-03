package com.danchoo.date.presentation.home.category.editor

import android.Manifest
import android.view.View
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.danchoo.components.permission.RequestPermission
import com.danchoo.date.presentation.common.gallery.domain.model.GalleryItemModel
import com.danchoo.date.presentation.home.category.editor.CategoryEditorContract.CategoryEditorIntent
import com.danchoo.date.presentation.home.category.editor.CategoryEditorContract.CategoryEditorSideEffect
import com.danchoo.date.presentation.home.category.editor.CategoryEditorContract.CategoryEditorViewEvent
import com.danchoo.date.presentation.utils.dialog.MediaSelectDialog
import com.danchoo.date.presentation.utils.dialog.MediaSelectType
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@Composable
fun CategoryEditorScreen(
    modifier: Modifier = Modifier,
    galleryItemModel: GalleryItemModel? = null,
    viewModel: CategoryEditorViewModel = hiltViewModel(),
    moveToGallery: () -> Unit = {},
    onClickBack: () -> Unit = {}
) {
    val viewState = viewModel.viewState.value
    val state = rememberCategoryEditorState()

    galleryItemModel?.let {
        viewModel.setEvent(
            CategoryEditorIntent.SaveGalleryModel(
                model = it,
                saveTempPath = state.getCacheDir().absolutePath
            )
        )
    }

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) {
        if (it) {
            viewModel.setEvent(CategoryEditorIntent.CameraTakePicture(state.selectMediaUri.value))
        }
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.sideEffect
            .onEach {
                when (it) {
                    is CategoryEditorSideEffect.CategoryCreateSuccess -> {
                        onClickBack()
                    }
                    else -> Unit
                }
            }
            .collect()
    }

    DisposableEffect(key1 = Unit) {
        onDispose {
            state.deleteTempFile()
        }
    }

    CategoryEditorScreenImpl(
        modifier = modifier,
        state = state,
        viewState = viewState
    ) {
        when (it) {
            is CategoryEditorViewEvent.OnClickBack -> onClickBack()
            is CategoryEditorViewEvent.OnTitleChanged -> {
                viewModel.setEvent(CategoryEditorIntent.TitleChanged(it.title))
            }
            is CategoryEditorViewEvent.OnDescriptionChanged -> {
                viewModel.setEvent(CategoryEditorIntent.DescriptionChanged(it.description))
            }
            is CategoryEditorViewEvent.OnVisibilityChanged -> {
                viewModel.setEvent(CategoryEditorIntent.VisibilityChanged(it.visibility))
            }
            is CategoryEditorViewEvent.OnClickImageChange -> {
                state.isShowMenuDialog.value = true
            }
            is CategoryEditorViewEvent.OnClickConfirm -> {
                viewModel.setEvent(
                    CategoryEditorIntent.CategoryCreate(
                        title = viewState.title,
                        description = viewState.description,
                        isVisibility = if (viewState.isVisibility) View.VISIBLE else View.GONE,
                        coverImageUri = viewState.coverImageUri,
                        currentTimestamp = System.currentTimeMillis()
                    )
                )
            }
        }
    }

    if (state.isShowMenuDialog.value) {
        MediaSelectDialog(
            onItemSelected = {
                when (it) {
                    MediaSelectType.Camera -> state.isShowCameraPermission.value = true
                    MediaSelectType.Gallery -> state.isShowReadStoragePermission.value = true
                }
            }
        ) {
            state.isShowMenuDialog.value = false
        }
    }

    if (state.isShowCameraPermission.value) {
        RequestPermission(
            permission = Manifest.permission.CAMERA,
            onSuccess = {
                launcher.launch(state.getMediaTempFileUri())
            },
            onDenied = {},
            onRequestMoveSetting = {},
            onRequestDismiss = {
                state.isShowCameraPermission.value = false
            }
        )
    } else if (state.isShowReadStoragePermission.value) {
        RequestPermission(
            permission = Manifest.permission.READ_EXTERNAL_STORAGE,
            onSuccess = { moveToGallery() },
            onDenied = {},
            onRequestMoveSetting = {},
            onRequestDismiss = {
                state.isShowReadStoragePermission.value = false
            }
        )
    }
}