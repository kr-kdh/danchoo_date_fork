package com.danchoo.category.domain.model

import com.danchoo.tags.domain.model.TagGroupModel
import com.danchoo.tags.domain.model.TagModel
import java.util.*


data class CategoryModel(
    val categoryId: Long = 0L,

    val hash: String = UUID.randomUUID().toString(),

    val title: String = "",

    val description: String = "",

    val coverImageUri: String = "",

    val readCount: Long = 0L,

    val createTimestamp: Long = 0L,

    val lastModifiedTimestamp: Long = 0L,

    val lastReadTimestamp: Long = 0L,

    val lastContentsModifiedTimestamp: Long = 0L,

    val tagGroupList: List<TagGroupModel> = emptyList(),

    val tagList: List<TagModel> = emptyList(),

    val visibility: Int = 0,

    var totalCount: Long = 0L,

    val revision: Long = 0
)
