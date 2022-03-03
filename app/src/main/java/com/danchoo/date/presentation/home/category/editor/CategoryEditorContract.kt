package com.danchoo.date.presentation.home.category.editor

import android.net.Uri
import com.danchoo.category.domain.model.CategoryModel
import com.danchoo.common.BaseIntent
import com.danchoo.common.BaseSideEffect
import com.danchoo.common.BaseViewState
import com.danchoo.components.event.ViewEvent
import com.danchoo.date.presentation.common.gallery.domain.model.GalleryItemModel

object CategoryEditorContract {

    sealed class CategoryEditorIntent : BaseIntent {
        data class CameraTakePicture(val uri: Uri) : CategoryEditorIntent()
        data class SaveGalleryModel(
            val model: GalleryItemModel,
            val saveTempPath: String
        ) : CategoryEditorIntent()

        data class CategoryCreate(
            val title: String,
            val description: String,
            val isVisibility: Int,
            val coverImageUri: Uri,
            val currentTimestamp: Long
        ) : CategoryEditorIntent()

        data class TitleChanged(val title: String) : CategoryEditorIntent()
        data class DescriptionChanged(val description: String) : CategoryEditorIntent()
        data class VisibilityChanged(val isVisibility: Boolean) : CategoryEditorIntent()
    }

    sealed class CategoryEditorSideEffect : BaseSideEffect {
        data class BitmapSaveError(val throwable: Throwable) : CategoryEditorSideEffect()
        data class FileSaveError(val throwable: Throwable) : CategoryEditorSideEffect()
        data class CategoryCreateSuccess(val category: CategoryModel) : CategoryEditorSideEffect()
        data class CategoryCreateError(val throwable: Throwable) : CategoryEditorSideEffect()
    }

    data class CategoryEditorViewState(
        val title: String = "",
        val description: String = "",
        val isVisibility: Boolean = false,
        val isCreate: Boolean = true,
        val coverImageUri: Uri = Uri.EMPTY,
        val isEnableConfirm: Boolean = false
    ) : BaseViewState

    sealed class CategoryEditorViewEvent : ViewEvent {
        object OnClickBack : CategoryEditorViewEvent()

        data class OnTitleChanged(
            val title: String
        ) : CategoryEditorViewEvent()

        data class OnDescriptionChanged(
            val description: String
        ) : CategoryEditorViewEvent()

        data class OnVisibilityChanged(
            val visibility: Boolean
        ) : CategoryEditorViewEvent()

        object OnClickImageChange : CategoryEditorViewEvent()

        object OnClickConfirm : CategoryEditorViewEvent()
    }
}