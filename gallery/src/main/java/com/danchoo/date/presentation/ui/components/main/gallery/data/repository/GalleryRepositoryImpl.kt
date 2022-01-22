package com.danchoo.date.presentation.ui.components.main.gallery.data.repository

import android.database.Cursor
import com.danchoo.date.presentation.ui.components.main.gallery.data.datasource.GalleryDataSource
import com.danchoo.date.presentation.ui.components.main.gallery.data.datasource.GalleryPagingSource
import com.danchoo.date.presentation.ui.components.main.gallery.domain.model.GalleryItemModel
import com.danchoo.date.presentation.ui.components.main.gallery.domain.repository.GalleryRepository
import kotlinx.coroutines.flow.Flow

class GalleryRepositoryImpl(
    private val dataSource: GalleryDataSource
) : GalleryRepository {
    override fun getGalleryItemList(count: Int): Flow<List<GalleryItemModel>> {
        return dataSource.getGalleryItemList(count)
    }

    override fun getGalleryItemList(start: Int, count: Int): List<GalleryItemModel> {
        return dataSource.getGalleryItemList(start, count)
    }

    override fun getGalleryItemList(cursor: Cursor, start: Int, count: Int): List<GalleryItemModel> {
        return dataSource.getGalleryItemList(cursor, start, count)
    }

    override fun getGalleryPagingSource(): GalleryPagingSource {
        return GalleryPagingSource(dataSource)
    }
}