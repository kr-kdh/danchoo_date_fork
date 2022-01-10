package com.danchoo.date.presentation.ui.components.main.gallery.data.repository

import android.database.Cursor
import com.danchoo.date.presentation.ui.components.main.gallery.data.datasource.GalleryDataSource
import com.danchoo.date.presentation.ui.components.main.gallery.domain.model.GalleryItemModel
import com.danchoo.date.presentation.ui.components.main.gallery.domain.repository.GalleryRepository
import kotlinx.coroutines.flow.Flow

class GalleryRepositoryImpl(
    private val dataSource: GalleryDataSource
) : GalleryRepository {
    override fun getMediaList(count: Int): Flow<List<GalleryItemModel>> {
        return dataSource.getMediaList(count)
    }

    override fun getMediaList(start: Int, count: Int): List<GalleryItemModel> {
        return dataSource.getMediaList(start, count)
    }

    override fun getMediaList(cursor: Cursor, start: Int, count: Int): List<GalleryItemModel> {
        return dataSource.getMediaList(cursor, start, count)
    }
}