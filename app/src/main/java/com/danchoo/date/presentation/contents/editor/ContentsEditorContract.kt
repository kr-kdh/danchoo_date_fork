package com.danchoo.date.presentation.contents.editor

import com.danchoo.common.BaseIntent
import com.danchoo.common.BaseSideEffect
import com.danchoo.common.BaseViewState
import com.danchoo.components.event.ViewEvent

object ContentsEditorContract {

    object ContentsEditorIntent : BaseIntent

    data class ContentsEditorViewState(
        val isCreate: Boolean = true,
        val categoryId: Long = 0
    ) : BaseViewState

    object ContentsEditorSideEffect : BaseSideEffect

    sealed class ContentsEditorViewEvent : ViewEvent {
        object OnClickBack : ContentsEditorViewEvent()
    }
}