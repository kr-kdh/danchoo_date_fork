package com.danchoo.date.data.db.entity

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
    val categoryId: Long,

    val hash: String = UUID.randomUUID().toString(),

    val title: String = "",

    val description: String = "",

    @ColumnInfo(name = "select_count")
    val selectCount: Long = 0L,

    @ColumnInfo(name = "create_time_stamp")
    val createTimestamp: Long = 0L,

    @ColumnInfo(name = "last_modified_timestamp")
    val lastModifiedTimestamp: Long = 0L,

    @ColumnInfo(name = "last_visit_timestamp")
    val lastVisitTimestamp: Long = 0L,

    @ColumnInfo(name = "last_contents_modified_timestamp")
    val lastContentsModifiedTimestamp: Long = 0L,

    @ColumnInfo(name = "total_count")
    val totalCount: Long = 0L,

    @ColumnInfo(name = "tag_group_id_list")
    val tagGroupIdList: List<Long> = emptyList(),

    @ColumnInfo(name = "tag_id_list")
    val tagIdList: List<Long> = emptyList(),

    val visibility: Int = 0,

    var revision: Long = 0
) {
}