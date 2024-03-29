package com.danchoo.date.presentation.home.category.editor

import android.net.Uri
import androidx.lifecycle.viewModelScope
import com.danchoo.category.domain.inspector.usecase.CategoryCreateUseCase
import com.danchoo.category.domain.inspector.usecase.CategoryCreateUseCase.CategoryCreateParameter
import com.danchoo.common.BaseViewModel
import com.danchoo.common.usecase.Result
import com.danchoo.commonutils.file.domain.inspector.SaveFileUseCase
import com.danchoo.commonutils.file.domain.inspector.SaveFileUseCase.SaveFileParameter
import com.danchoo.date.presentation.common.gallery.domain.model.GalleryItemModel
import com.danchoo.date.presentation.home.category.editor.CategoryEditorContract.CategoryEditorEvent
import com.danchoo.date.presentation.home.category.editor.CategoryEditorContract.CategoryEditorSideEffect
import com.danchoo.date.presentation.home.category.editor.CategoryEditorContract.CategoryEditorViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryEditorViewModel @Inject constructor(
    private val saveFileUseCase: SaveFileUseCase,
    private val categoryCreateUseCase: CategoryCreateUseCase
) : BaseViewModel<CategoryEditorEvent, CategoryEditorViewState, CategoryEditorSideEffect>() {
    override fun setInitialState() = CategoryEditorViewState()

    override fun handleEvents(event: CategoryEditorEvent) {
//        val list = mutableListOf(1,2,3)
//        list.sort()

        when (event) {
            is CategoryEditorEvent.CameraTakePicture -> cameraTakePicture(event.uri)
            is CategoryEditorEvent.SaveGalleryModel -> saveGalleryModel(
                event.model,
                event.saveTempPath
            )
            is CategoryEditorEvent.CategoryCreate -> categoryCreate(event)
            is CategoryEditorEvent.DescriptionChanged -> descriptionChanged(event.description)
            is CategoryEditorEvent.TitleChanged -> titleChanged(event.title)
            is CategoryEditorEvent.VisibilityChanged -> visibilityChanged(event.isVisibility)
        }
    }

    private fun titleChanged(title: String) {
        viewModelScope.launch {
            setState { copy(title = title) }
        }
    }

    private fun descriptionChanged(description: String) {
        viewModelScope.launch {
            setState { copy(description = description) }
        }
    }

    private fun visibilityChanged(isVisibility: Boolean) {
        viewModelScope.launch {
            setState { copy(isVisibility = isVisibility) }
        }
    }

    private fun cameraTakePicture(uri: Uri) {
        viewModelScope.launch {
            setState { copy(coverImageUri = uri) }
        }
    }

    private fun saveGalleryModel(galleryItemModel: GalleryItemModel, savePath: String) {
        viewModelScope.launch {
            val uri = galleryItemModel.uri ?: return@launch
            val result = saveFileUseCase(
                SaveFileParameter(
                    uri = uri,
                    savePath = savePath,
                )
            )

            when (result) {
                is Result.Success -> setState { copy(coverImageUri = result.data.uri) }
                is Result.Error -> setEffect { CategoryEditorSideEffect.FileSaveError(result.exception) }
                else -> Unit
            }
        }
    }

    private fun categoryCreate(event: CategoryEditorEvent.CategoryCreate) {
        viewModelScope.launch {
            val result = categoryCreateUseCase(
                CategoryCreateParameter(
                    title = event.title,
                    description = event.description,
                    visibility = event.isVisibility,
                    coverImageUri = event.coverImageUri,
                    currentTimestamp = event.currentTimestamp
                )
            )

            when (result) {
                is Result.Success -> setEffect {
                    CategoryEditorSideEffect.CategoryCreateSuccess(
                        result.data
                    )
                }
                is Result.Error -> setEffect { CategoryEditorSideEffect.CategoryCreateError(result.exception) }
                else -> Unit
            }
        }
    }

}