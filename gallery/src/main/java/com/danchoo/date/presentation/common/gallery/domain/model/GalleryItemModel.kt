package com.danchoo.date.presentation.common.gallery.domain.model

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GalleryItemModel(
    val id: Int,
    val uri: Uri? = null,
    val name: String,
    val addedDate: String,
    val modifiedDate: String,
    val size: Long,
    val createDate: Long,
    val mediaType: Int,
    val mineType: String
) : Parcelable

const val GALLERY_ITEM_MODEL = "GalleryItemModel"
