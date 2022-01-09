package com.danchoo.date.presentation.ui.components.main.gallery

import com.danchoo.common.BaseIntent
import com.danchoo.common.BaseSideEffect
import com.danchoo.common.BaseViewState
import com.danchoo.components.event.ViewEvent

object GalleryContract {

    sealed class GalleryIntent : BaseIntent {
        object Idle : GalleryIntent()
    }

    sealed class GallerySideEffect : BaseSideEffect {
        object Idle : GallerySideEffect()
    }

    data class GalleryViewState(
        val isCreate: Boolean = true
    ) : BaseViewState

    sealed class GalleryViewEvent : ViewEvent {
        object OnClickBackPress : GalleryViewEvent()
    }
}