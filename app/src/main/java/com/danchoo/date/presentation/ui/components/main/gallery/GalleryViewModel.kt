package com.danchoo.date.presentation.ui.components.main.gallery

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.danchoo.common.BaseViewModel
import com.danchoo.date.presentation.ui.components.main.gallery.domain.repository.GalleryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(InternalCoroutinesApi::class)
@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val repository: GalleryRepository
) : BaseViewModel<GalleryContract.GalleryIntent, GalleryContract.GalleryViewState, GalleryContract.GallerySideEffect>() {

    init {
        aa()
    }

    private fun aa() {
        viewModelScope.launch {
            repository.getMediaList(100)
                .flowOn(Dispatchers.IO)
                .collect {
                    setState {
                        val items = galleryItemList.toMutableList().apply { addAll(it) }
                        Log.d("_SMY", " GalleryViewModel  ${items.size}")
                        copy(galleryItemList = items)
                    }
                }
        }
    }

    override fun setInitialState() = GalleryContract.GalleryViewState()

    override fun handleEvents(event: GalleryContract.GalleryIntent) {
    }
}
