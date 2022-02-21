package com.danchoo.date.presentation.editor.category

import android.graphics.Bitmap
import android.net.Uri
import com.danchoo.category.domain.model.CategoryModel
import com.danchoo.common.BaseIntent
import com.danchoo.common.BaseSideEffect
import com.danchoo.common.BaseViewState
import com.danchoo.components.event.ViewEvent
import com.danchoo.date.presentation.gallery.domain.model.GalleryItemModel

object CategoryEditorContract {

    sealed class CategoryEditorIntent : BaseIntent {
        data class SaveBitmap(val bitmap: Bitmap?) : CategoryEditorIntent()
        data class SaveGalleryModel(val model: GalleryItemModel) : CategoryEditorIntent()
        data class CategoryCreate(
            val title: String,
            val description: String,
            val isVisibility: Int,
            val coverImageUri: Uri,
            val currentTimestamp: Long
        ) : CategoryEditorIntent()
    }

    sealed class CategoryEditorSideEffect : BaseSideEffect {
        data class BitmapSaveError(val throwable: Throwable) : CategoryEditorSideEffect()
        data class FileSaveError(val throwable: Throwable) : CategoryEditorSideEffect()
        data class CategoryCreateSuccess(val category: CategoryModel) : CategoryEditorSideEffect()
        data class CategoryCreateError(val throwable: Throwable) : CategoryEditorSideEffect()
    }

    data class CategoryEditorViewState(
        val isCreate: Boolean = true,
        val coverImageUri: Uri = Uri.EMPTY
    ) : BaseViewState

    sealed class CategoryEditorViewEvent : ViewEvent {
        object OnClickBackPress : CategoryEditorViewEvent()

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