package com.danchoo.category.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "category_tag_group_info",
    primaryKeys = ["category_id", "group_id"]
)
data class CategoryTagGroupInfo(
    @ColumnInfo(name = "category_id")
    val categoryId: Long,

    @ColumnInfo(name = "group_id")
    val tagGroupId: Long,
)
