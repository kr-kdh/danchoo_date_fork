package com.danchoo.date.presentation.contents.editor

import com.danchoo.components.event.ViewEvent

object ContentsEditorContract {

    sealed class ContentsEditorViewEvent : ViewEvent {
        object OnClickBack : ContentsEditorViewEvent()
    }
}