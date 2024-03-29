package com.danchoo.date.presentation.contents

import com.danchoo.common.BaseEvent
import com.danchoo.common.BaseSideEffect
import com.danchoo.common.BaseViewState
import com.danchoo.components.event.ViewEvent

object ContentsContract {

    object ContentsEvent : BaseEvent

    data class ContentsViewState(
        val categoryId: Long = 0
    ) : BaseViewState

    object ContentsSideEffect : BaseSideEffect


    sealed class ContentsViewEvent : ViewEvent {
        object OnClickBack : ContentsViewEvent()
        object OnClickAdd : ContentsViewEvent()
        data class OnClickContent(val contentsId: Long) : ContentsViewEvent()
    }
}