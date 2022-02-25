package com.danchoo.date.presentation.common.gallery

import com.danchoo.common.BaseIntent
import com.danchoo.common.BaseSideEffect
import com.danchoo.common.BaseViewState
import com.danchoo.components.event.ViewEvent
import com.danchoo.date.presentation.common.gallery.domain.model.GalleryItemModel

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
        data class OnClickGalleryItem(val galleryItem: GalleryItemModel) : GalleryViewEvent()
    }
}