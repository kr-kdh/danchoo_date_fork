package com.danchoo.components.ui.cardview

import com.danchoo.components.event.ViewEvent

object CardViewConstants {
    sealed class CardViewEvent : ViewEvent {
        data class ClickExpand(val expand: Boolean) : CardViewEvent()
        data class ChangeExpandEnableState(val enable: Boolean) : CardViewEvent()
    }
}

enum class CardViewContentsType {
    Normal,
    SmallImage,
    SmallImages,
    BigImage
}

const val DESCRIPTION_MAX_LINE = 4
const val DESCRIPTION_MIN_LINE = 2
