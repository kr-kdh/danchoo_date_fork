package com.danchoo.date.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "contents",
    indices = [Index(value = ["hash"], unique = true)]
)
data class Contents(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "contents_id")
    val contentsId: Long,

    @ColumnInfo(name = "category_id")
    val categoryId: Long,

    val hash: String = UUID.randomUUID().toString(),

    val title: String = "",

    val creator: Long = 0L,

    @ColumnInfo(name = "contents_id_list")
    val contentsIdList: List<Long> = emptyList(),

    @ColumnInfo(name = "select_count")
    val selectCount: Long = 0L,

    @ColumnInfo(name = "create_time_stamp")
    val createTimestamp: Long = 0L,

    @ColumnInfo(name = "last_visit_timestamp")
    val lastVisitTimestamp: Long = 0L,

    @ColumnInfo(name = "tag_group_id_list")
    val tagGroupIdList: List<Long> = emptyList(),

    @ColumnInfo(name = "tag_id_list")
    val tagIdList: List<Long> = emptyList(),

    val visibility: Int = 0,

    val share: Int = 0,

    var revision: Long = 0
)