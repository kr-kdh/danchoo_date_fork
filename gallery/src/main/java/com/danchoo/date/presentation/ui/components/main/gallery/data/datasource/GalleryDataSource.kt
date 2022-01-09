package com.danchoo.date.presentation.ui.components.main.gallery.data.datasource

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GalleryDataSource(private val context: Context) {
    fun getMediaList(count: Int): Flow<List<String>> {
        return flow<List<String>> {
            val mediaItemList = mutableListOf<String>()
            val cursor = getCursor()

            while (cursor.moveToNext()) {
                mediaItemList.add("1")

                if (mediaItemList.size == count) {
                    emit(mediaItemList.toList())
                    mediaItemList.clear()
                }
            }

            cursor.close()
        }
    }

    fun getMediaList(start: Int, count: Int): List<String> {
        val mediaItemList = mutableListOf<String>()
        val cursor = getCursor()

        cursor.moveToPosition(start)

        while (cursor.moveToNext()) {
            mediaItemList.add("1")

            if (mediaItemList.size == count) {
                break
            }
        }

        cursor.close()

        return mediaItemList
    }

    fun getMediaList(cursor: Cursor, start: Int, count: Int): List<String> {
        val mediaItemList = mutableListOf<String>()

        cursor.moveToPosition(start)

        while (cursor.moveToNext()) {
            mediaItemList.add("1")

            if (mediaItemList.size == count) {
                break
            }
        }

        return mediaItemList
    }


    private fun getCursor(): Cursor {
        val projection = getMediaProjection()
        val selection = getAllMediaSelection()

        val resolver = context.contentResolver

        return resolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            projection,
            selection,
            null,
            MediaStore.Images.Media.DATE_MODIFIED + " desc"
        ) ?: throw Exception()
    }


    private fun getMediaProjection(): Array<String> {
        return arrayOf(
            MediaStore.MediaColumns._ID,
            MediaStore.MediaColumns.DISPLAY_NAME,
            MediaStore.MediaColumns.DATE_ADDED,
            MediaStore.MediaColumns.DATE_MODIFIED,
            MediaStore.MediaColumns.SIZE,
            MediaStore.Images.Media.DATE_TAKEN,
            MediaStore.Files.FileColumns.MEDIA_TYPE,
            MediaStore.Files.FileColumns.MIME_TYPE
        )
    }

    private fun getAllMediaSelection(): String {
        return StringBuilder()
            .append(MediaStore.Files.FileColumns.MEDIA_TYPE)
            .append("=")
            .append(MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE)
            .append(" OR ")
            .append(MediaStore.Files.FileColumns.MEDIA_TYPE)
            .append("=")
            .append(MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO)
            .toString()
    }
}