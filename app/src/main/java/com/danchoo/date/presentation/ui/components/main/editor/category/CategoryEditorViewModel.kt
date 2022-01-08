package com.danchoo.date.presentation.ui.components.main.editor.category

import android.graphics.Bitmap
import androidx.lifecycle.viewModelScope
import com.danchoo.common.BaseViewModel
import com.danchoo.commonutils.file.FileConfiguration
import com.danchoo.commonutils.file.domain.inspector.SaveBitmapUseCase
import com.danchoo.date.presentation.ui.components.main.editor.category.CategoryEditorContract.CategoryEditorIntent
import com.danchoo.date.presentation.ui.components.main.editor.category.CategoryEditorContract.CategoryEditorSideEffect
import com.danchoo.date.presentation.ui.components.main.editor.category.CategoryEditorContract.CategoryEditorViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CategoryEditorViewModel @Inject constructor(
    private val fileConfiguration: FileConfiguration,
    private val saveBitmapUseCase: SaveBitmapUseCase
) : BaseViewModel<CategoryEditorIntent, CategoryEditorViewState, CategoryEditorSideEffect>() {
    override fun setInitialState() = CategoryEditorViewState()

    override fun handleEvents(event: CategoryEditorIntent) {
        when (event) {
            is CategoryEditorIntent.SaveBitmap -> saveBitmap(event.bitmap)
        }
    }

    private fun saveBitmap(bitmap: Bitmap?) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                saveBitmapUseCase(
                    bitmap = bitmap,
                    path = fileConfiguration.cacheDirAbsolutePath,
                    fileName = fileConfiguration.getTempFileName()
                )
            }

            if (result.filePath.isNotEmpty()) {
                setState { copy(coverImagePath = result.filePath) }
            } else {
                setEffect { CategoryEditorSideEffect.BitmapSaveError(result.error) }
            }
        }
    }
}