package com.danchoo.date.presentation.editor.category

import android.Manifest
import android.view.View
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.danchoo.components.permission.RequestPermission
import com.danchoo.date.presentation.common.dialog.MediaSelectDialog
import com.danchoo.date.presentation.common.dialog.MediaSelectType
import com.danchoo.date.presentation.editor.category.CategoryEditorContract.CategoryEditorIntent
import com.danchoo.date.presentation.editor.category.CategoryEditorContract.CategoryEditorSideEffect
import com.danchoo.date.presentation.editor.category.CategoryEditorContract.CategoryEditorViewEvent
import com.danchoo.date.presentation.gallery.domain.model.GalleryItemModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@Composable
fun CategoryEditorScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    galleryItemModel: GalleryItemModel? = null,
    viewModel: CategoryEditorViewModel = hiltViewModel()
) {
    val viewState = viewModel.viewState.value
    val state = rememberCategoryEditorState(navController)

    galleryItemModel?.let {
        viewModel.setEvent(CategoryEditorIntent.SaveGalleryModel(it))
    }

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) {
        viewModel.setEvent(CategoryEditorIntent.SaveBitmap(it))
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
            onSuccess = { launcher.launch() },
            onDenied = {},
            onRequestMoveSetting = {},
            onRequestDismiss = {
                state.isShowCameraPermission.value = false
            }
        )
    } else if (state.isShowReadStoragePermission.value) {
        RequestPermission(
            permission = Manifest.permission.READ_EXTERNAL_STORAGE,
            onSuccess = { state.moveToGallery() },
            onDenied = {},
            onRequestMoveSetting = {},
            onRequestDismiss = {
                state.isShowReadStoragePermission.value = false
            }
        )
    }
}