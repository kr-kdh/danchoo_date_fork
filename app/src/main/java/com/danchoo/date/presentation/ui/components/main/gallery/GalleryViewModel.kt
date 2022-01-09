package com.danchoo.date.presentation.ui.components.main.gallery

import com.danchoo.common.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class GalleryViewModel @Inject constructor(

) : BaseViewModel<GalleryContract.GalleryIntent, GalleryContract.GalleryViewState, GalleryContract.GallerySideEffect>() {
    override fun setInitialState() = GalleryContract.GalleryViewState()

    override fun handleEvents(event: GalleryContract.GalleryIntent) {
    }
}
