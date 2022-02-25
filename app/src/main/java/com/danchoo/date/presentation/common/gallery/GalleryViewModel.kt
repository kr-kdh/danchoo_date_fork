package com.danchoo.date.presentation.common.gallery

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.danchoo.common.BaseViewModel
import com.danchoo.date.presentation.common.gallery.domain.inspector.GalleryPagingUseCase
import com.danchoo.date.presentation.common.gallery.domain.model.GalleryItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@OptIn(InternalCoroutinesApi::class)
@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val pagingUseCase: GalleryPagingUseCase,
) : BaseViewModel<GalleryContract.GalleryIntent, GalleryContract.GalleryViewState, GalleryContract.GallerySideEffect>() {

    init {
    }

    private val galleryListFlow = pagingUseCase().cachedIn(viewModelScope)

    fun galleryPagingItems(): Flow<PagingData<GalleryItemModel>> {
        return galleryListFlow
    }

    override fun setInitialState() = GalleryContract.GalleryViewState()

    override fun handleEvents(event: GalleryContract.GalleryIntent) {
    }
}
