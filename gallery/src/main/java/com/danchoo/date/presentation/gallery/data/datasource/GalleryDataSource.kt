package com.danchoo.date.presentation.gallery.data.datasource

import android.database.Cursor
import com.danchoo.date.presentation.gallery.domain.model.GalleryItemModel
import kotlinx.coroutines.flow.Flow

interface GalleryDataSource {
    fun getDefaultCursor(): Cursor

    fun getGalleryItemList(count: Int): Flow<List<GalleryItemModel>>

    fun getGalleryItemList(start: Int, count: Int): List<GalleryItemModel>

    fun getGalleryItemList(cursor: Cursor, start: Int, count: Int): List<GalleryItemModel>
}