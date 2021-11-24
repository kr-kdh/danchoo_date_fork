package com.danchoo.date.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(
    tableName = "contents_media",
    indices = [Index(value = ["hash"], unique = true)]
)
data class ContentsMedia(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "media_id")
    val mediaId: Long,

    @ColumnInfo(name = "contents_id")
    val contentsId: Long,

    val hash: Long,

    val type: Int,

    @ColumnInfo(name = "original_key")
    val originalKey: String,

    @ColumnInfo(name = "original_local_path")
    val originalLocalPath: String,

    @ColumnInfo(name = "thumbnail_key")
    val thumbnailKey: String,

    @ColumnInfo(name = "thumbnail_local_path")
    val thumbnailLocalPath: String,

    val visibility: Int = 0
)
