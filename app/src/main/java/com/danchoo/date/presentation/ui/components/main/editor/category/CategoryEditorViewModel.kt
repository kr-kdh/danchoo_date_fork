package com.danchoo.date.presentation.ui.components.main.editor.category

import android.graphics.Bitmap
import androidx.lifecycle.viewModelScope
import com.danchoo.category.domain.inspector.usecase.CategoryCreateUseCase
import com.danchoo.category.domain.inspector.usecase.CategoryCreateUseCase.CategoryCreateParameter
import com.danchoo.common.BaseViewModel
import com.danchoo.commonutils.file.FileConfiguration
import com.danchoo.commonutils.file.domain.inspector.SaveBitmapUseCase
import com.danchoo.commonutils.file.domain.inspector.SaveBitmapUseCase.SaveBitmapParameter
import com.danchoo.commonutils.file.domain.inspector.SaveFileUseCase
import com.danchoo.commonutils.file.domain.inspector.SaveFileUseCase.SaveFileParameter
import com.danchoo.date.presentation.ui.components.main.editor.category.CategoryEditorContract.CategoryEditorIntent
import com.danchoo.date.presentation.ui.components.main.editor.category.CategoryEditorContract.CategoryEditorSideEffect
import com.danchoo.date.presentation.ui.components.main.editor.category.CategoryEditorContract.CategoryEditorViewState
import com.danchoo.date.presentation.ui.components.main.gallery.domain.model.GalleryItemModel
import com.danchoo.inspactor.usecase.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryEditorViewModel @Inject constructor(
    private val fileConfiguration: FileConfiguration,
    private val saveBitmapUseCase: SaveBitmapUseCase,
    private val saveFileUseCase: SaveFileUseCase,
    private val categoryCreateUseCase: CategoryCreateUseCase
) : BaseViewModel<CategoryEditorIntent, CategoryEditorViewState, CategoryEditorSideEffect>() {
    override fun setInitialState() = CategoryEditorViewState()

    override fun handleEvents(event: CategoryEditorIntent) {
        when (event) {
            is CategoryEditorIntent.SaveBitmap -> saveBitmap(event.bitmap)
            is CategoryEditorIntent.SaveGalleryModel -> saveGalleryModel(event.model)
            is CategoryEditorIntent.CategoryCreate -> categoryCreate(event)
        }
    }

    private fun saveBitmap(bitmap: Bitmap?) {
        viewModelScope.launch {
            val result = saveBitmapUseCase(
                SaveBitmapParameter(
                    bitmap = bitmap,
                    savePath = fileConfiguration.cacheDirAbsolutePath,
                    fileName = fileConfiguration.getTempFileName()
                )
            )

            when (result) {
                is Result.Success -> setState { copy(coverImageUri = result.data.uri) }
                is Result.Error -> setEffect { CategoryEditorSideEffect.BitmapSaveError(result.exception) }
                else -> Unit
            }
        }
    }

    private fun saveGalleryModel(galleryItemModel: GalleryItemModel) {
        viewModelScope.launch {
            val uri = galleryItemModel.uri ?: return@launch
            val result = saveFileUseCase(
                SaveFileParameter(
                    uri = uri,
                    savePath = fileConfiguration.cacheDirAbsolutePath,
                )
            )

            when (result) {
                is Result.Success -> setState { copy(coverImageUri = result.data.uri) }
                is Result.Error -> setEffect { CategoryEditorSideEffect.FileSaveError(result.exception) }
                else -> Unit
            }
        }
    }

    private fun categoryCreate(event: CategoryEditorIntent.CategoryCreate) {
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
                is Result.Success -> setEffect { CategoryEditorSideEffect.CategoryCreateSuccess(result.data) }
                is Result.Error -> setEffect { CategoryEditorSideEffect.CategoryCreateError(result.exception) }
                else -> Unit
            }
        }
    }
}