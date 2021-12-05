package com.danchoo.components.ui.cardview

import com.danchoo.components.event.ViewEvent

object CardViewConstants {
    sealed class CardViewEvent : ViewEvent {
        data class ClickExpand(val expand: Boolean) : CardViewEvent()
        data class ChangeExpandEnableState(val enable: Boolean) : CardViewEvent()
    }
}