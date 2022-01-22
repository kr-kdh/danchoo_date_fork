package com.danchoo.date.presentation.ui.components.main.gallery.data.datasource

import android.database.Cursor
import com.danchoo.date.presentation.ui.components.main.gallery.domain.model.GalleryItemModel
import kotlinx.coroutines.flow.Flow

interface GalleryDataSource {
    fun getMediaList(count: Int): Flow<List<GalleryItemModel>>

    fun getMediaList(start: Int, count: Int): List<GalleryItemModel>

    fun getMediaList(cursor: Cursor, start: Int, count: Int): List<GalleryItemModel>
}