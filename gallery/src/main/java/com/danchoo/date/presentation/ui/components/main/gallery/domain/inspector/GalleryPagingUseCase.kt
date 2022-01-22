package com.danchoo.date.presentation.ui.components.main.gallery.domain.inspector

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.danchoo.date.presentation.ui.components.main.gallery.domain.model.GalleryItemModel
import com.danchoo.date.presentation.ui.components.main.gallery.domain.repository.GalleryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GalleryPagingUseCase @Inject constructor(
    val repository: GalleryRepository
) {
    operator fun invoke(): Flow<PagingData<GalleryItemModel>> = Pager(
        config = PagingConfig(
            pageSize = 30,
            prefetchDistance = 30,
            maxSize = 30 * 5
        )
    ) {
        repository.getGalleryPagingSource()
    }.flow
}