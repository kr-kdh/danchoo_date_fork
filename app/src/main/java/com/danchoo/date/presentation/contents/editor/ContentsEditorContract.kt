package com.danchoo.date.presentation.contents.editor

import com.danchoo.common.BaseIntent
import com.danchoo.common.BaseSideEffect
import com.danchoo.common.BaseViewState
import com.danchoo.components.event.ViewEvent
import com.danchoo.contents.domain.model.ContentsMediaModel

object ContentsEditorContract {

    object ContentsEditorIntent : BaseIntent

    data class ContentsEditorViewState(
        val isCreate: Boolean = true,
        val categoryId: Long = 0,
        val isEnableConfirm: Boolean = false,
        val mediaList: List<ContentsMediaModel> = emptyList()
    ) : BaseViewState

    object ContentsEditorSideEffect : BaseSideEffect

    sealed class ContentsEditorViewEvent : ViewEvent {
        object OnClickBack : ContentsEditorViewEvent()
        object OnClickConfirm : ContentsEditorViewEvent()
        data class OnClickDeleteMedia(val mediaModel: ContentsMediaModel) :
            ContentsEditorViewEvent()
    }
}