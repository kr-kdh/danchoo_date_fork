package com.danchoo.date.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "tag_group",
    indices = [Index(value = ["hash"], unique = true)]
)
data class TagGroup(
    @PrimaryKey
    @ColumnInfo(name = "group_id")
    val groupId: Long = 0L,

    val hash: String = UUID.randomUUID().toString(),

    val title: String = "",

    @ColumnInfo(name = "create_time_stamp")
    val createTimestamp: Long = 0L,

    val visibility: Int = 0,

    @ColumnInfo(name = "select_count")
    val selectCount: Long = 0,
)