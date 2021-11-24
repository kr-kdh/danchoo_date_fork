package com.danchoo.contents.domain.model

data class ContentsMediaModel(
    val mediaId: Long,

    val hash: Long,

    val type: Int,

    val originalKey: String,

    val originalLocalPath: String,

    val thumbnailKey: String,

    val thumbnailLocalPath: String,

    val visibility: Int = 0
)