package com.danchoo.date.presentation.common.gallery.domain.repository

import android.database.Cursor
import com.danchoo.date.presentation.common.gallery.data.datasource.GalleryPagingSource
import com.danchoo.date.presentation.common.gallery.domain.model.GalleryItemModel
import kotlinx.coroutines.flow.Flow

interface GalleryRepository {
    fun getGalleryItemList(count: Int): Flow<List<GalleryItemModel>>

    fun getGalleryItemList(start: Int, count: Int): List<GalleryItemModel>

    fun getGalleryItemList(cursor: Cursor, start: Int, count: Int): List<GalleryItemModel>

    fun getGalleryPagingSource(): GalleryPagingSource
}