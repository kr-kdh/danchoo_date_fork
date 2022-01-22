package com.danchoo.date.presentation.ui.components.main.gallery

import com.danchoo.common.BaseIntent
import com.danchoo.common.BaseSideEffect
import com.danchoo.common.BaseViewState
import com.danchoo.components.event.ViewEvent
import com.danchoo.date.presentation.ui.components.main.gallery.domain.model.GalleryItemModel

object GalleryContract {

    sealed class GalleryIntent : BaseIntent {
        object Idle : GalleryIntent()
    }

    sealed class GallerySideEffect : BaseSideEffect {
        object Idle : GallerySideEffect()
    }

    data class GalleryViewState(
        val isCreate: Boolean = true,
        val galleryItemList: List<GalleryItemModel> = emptyList()
    ) : BaseViewState

    sealed class GalleryViewEvent : ViewEvent {
        object OnClickBackPress : GalleryViewEvent()
    }
}