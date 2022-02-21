package com.danchoo.date.presentation.gallery.domain.inspector

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.danchoo.date.presentation.gallery.domain.model.GalleryItemModel
import com.danchoo.date.presentation.gallery.domain.repository.GalleryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GalleryPagingUseCase @Inject constructor(
    val repository: GalleryRepository
) {
    companion object {
        private const val PAGE_SIZE = 30
    }

    operator fun invoke(): Flow<PagingData<GalleryItemModel>> = Pager(
        config = PagingConfig(
            pageSize = PAGE_SIZE,
            prefetchDistance = PAGE_SIZE
        )
    ) {
        repository.getGalleryPagingSource()
    }.flow
}