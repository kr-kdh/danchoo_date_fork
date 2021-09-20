package com.danchoo.date.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "tag",
    indices = [Index(value = ["hash"], unique = true)]
)
data class Tag(
    @PrimaryKey
    @ColumnInfo(name = "tag_id")
    val tagId: Long = 0L,

    val hash: String = UUID.randomUUID().toString(),

    @ColumnInfo(name = "group_id")
    val groupId: Long = 0L,

    val tag: String = "",

    @ColumnInfo(name = "create_time_stamp")
    val createTimestamp: Long = 0L,

    val visibility: Int = 0,

    @ColumnInfo(name = "select_count")
    val selectCount: Long = 0,

    @ColumnInfo(name = "relation_group_id_list")
    val relationGroupIdList: List<Long> = emptyList(),

    @ColumnInfo(name = "relation_tag_id_list")
    val relationTagIdList: List<Long> = emptyList()

)
