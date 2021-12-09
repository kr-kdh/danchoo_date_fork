package com.danchoo.date.presentation.ui.components.main.editor.category

import androidx.compose.ui.text.input.TextFieldValue
import com.danchoo.common.BaseIntent
import com.danchoo.common.BaseSideEffect
import com.danchoo.common.BaseViewState
import com.danchoo.components.event.ViewEvent

object CategoryEditorContract {

    sealed class CategoryEditorIntent : BaseIntent {
        object Idle : CategoryEditorIntent()
    }

    sealed class CategoryEditorSideEffect : BaseSideEffect {
        object Idle : CategoryEditorSideEffect()
    }

    data class CategoryEditorViewState(
        val isCreate: Boolean = true
    ) : BaseViewState

    sealed class CategoryEditorViewEvent : ViewEvent {
        data class TitleChanged(
            val textFieldValue: TextFieldValue
        ) : CategoryEditorViewEvent()

        data class DescriptionChanged(
            val textFieldValue: TextFieldValue
        ) : CategoryEditorViewEvent()

        data class VisibilityChanged(
            val visibility: Boolean
        ) : CategoryEditorViewEvent()

    }
}