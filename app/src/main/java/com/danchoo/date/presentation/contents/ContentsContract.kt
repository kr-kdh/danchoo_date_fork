package com.danchoo.date.presentation.contents

import com.danchoo.components.event.ViewEvent

object ContentsContract {

    sealed class ContentsEditorViewEvent : ViewEvent {
        object OnClickBack : ContentsEditorViewEvent()
        object OnClickAdd : ContentsEditorViewEvent()
        data class OnClickContent(val contentsId: Long) : ContentsEditorViewEvent()
    }
}