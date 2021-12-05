package com.danchoo.components.ui.appbar

import com.danchoo.components.event.ViewEvent

object AppBarConstants {
    sealed class AppBarEvent : ViewEvent {
        object Back : AppBarEvent()
    }
}

enum class TopAppbarType {
    Title,
    Back,
    Search,
    More,
    Edit
}
