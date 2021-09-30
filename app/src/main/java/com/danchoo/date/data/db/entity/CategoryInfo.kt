package com.danchoo.date.data.db.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class CategoryInfo(
    @Embedded
    val category: Category,

    @Relation(
        parentColumn = "category_id",
        entityColumn = "group_id",
        associateBy = Junction(CategoryTagGroupInfo::class)
    )
    val tagGroupList: List<TagGroup> = emptyList(),

    @Relation(
        parentColumn = "category_id",
        entityColumn = "tag_id",
        associateBy = Junction(CategoryTagInfo::class)
    )
    val tagList: List<Tag> = emptyList()
)