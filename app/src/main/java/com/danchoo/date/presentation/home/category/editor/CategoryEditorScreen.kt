package com.danchoo.date.presentation.home.category.editor

import android.Manifest
import android.view.View
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
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
    navController: NavController,
    galleryItemModel: GalleryItemModel? = null,
    viewModel: CategoryEditorViewModel = hiltViewModel(),
    moveToGallery: () -> Unit
) {
    val viewState = viewModel.viewState.value
    val state = rememberCategoryEditorState(navController)
    val context = LocalContext.current

    galleryItemModel?.let {
        viewModel.setEvent(
            CategoryEditorIntent.SaveGalleryModel(
                model = it,
                saveTempPath = state.getCacheDir(context).absolutePath
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
                        state.popBackStack()
                    }
                    else -> Unit
                }
            }
            .collect()
    }

    DisposableEffect(key1 = Unit) {
        onDispose {
            state.deleteTempFile(context)
        }
    }

    CategoryEditorScreenImpl(
        modifier = modifier,
        state = state,
        viewState = viewState
    ) {
        when (it) {
            is CategoryEditorViewEvent.OnClickBack -> state.popBackStack()
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
            is CategoryEditorViewEvent.OnClickConfirm -> {
                viewModel.setEvent(
                    CategoryEditorIntent.CategoryCreate(
                        title = state.title.value,
                        description = state.description.value,
                        isVisibility = if (state.isVisibility.value) View.VISIBLE else View.GONE,
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
                launcher.launch(state.getMediaTempFileUri(context))
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