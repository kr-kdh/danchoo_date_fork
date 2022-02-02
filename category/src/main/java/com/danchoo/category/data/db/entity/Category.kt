package com.danchoo.category.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "category",
    indices = [androidx.room.Index(value = ["hash"], unique = true)]
)
data class Category(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "category_id")
    val categoryId: Long = 0L,

    val hash: String = UUID.randomUUID().toString(),

    val title: String = "",

    val description: String = "",

    val coverImage: String = "",

    @ColumnInfo(name = "read_count")
    val readCount: Long = 0L,

    @ColumnInfo(name = "create_time_stamp")
    val createTimestamp: Long = 0L,

    @ColumnInfo(name = "last_modified_timestamp")
    val lastModifiedTimestamp: Long = 0L,

    @ColumnInfo(name = "last_read_timestamp")
    val lastReadTimestamp: Long = 0L,

    @ColumnInfo(name = "last_contents_modified_timestamp")
    val lastContentsModifiedTimestamp: Long = 0L,

    @ColumnInfo(name = "total_count")
    val totalCount: Long = 0L,

    val visibility: Int = 0,

    var revision: Long = 0
)