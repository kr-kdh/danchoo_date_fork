package com.danchoo.date.presentation.ui.components.main.editor.category

import android.graphics.Bitmap
import com.danchoo.common.BaseIntent
import com.danchoo.common.BaseSideEffect
import com.danchoo.common.BaseViewState
import com.danchoo.components.event.ViewEvent

object CategoryEditorContract {

    sealed class CategoryEditorIntent : BaseIntent {
        data class SaveBitmap(val bitmap: Bitmap?) : CategoryEditorIntent()
    }

    sealed class CategoryEditorSideEffect : BaseSideEffect {
        object Idle : CategoryEditorSideEffect()
        data class BitmapSaveError(val error: Int) : CategoryEditorSideEffect()
    }

    data class CategoryEditorViewState(
        val isCreate: Boolean = true,
        val coverImagePath: String = ""
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
    }
}