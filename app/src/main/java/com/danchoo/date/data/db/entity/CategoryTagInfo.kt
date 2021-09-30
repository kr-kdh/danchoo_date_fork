package com.danchoo.date.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "category_tag_info",
    primaryKeys = ["category_id", "tag_id"]
)
data class CategoryTagInfo(
    @ColumnInfo(name = "category_id")
    val categoryId: Long,

    @ColumnInfo(name = "tag_id")
    val tagId: Long,
)
