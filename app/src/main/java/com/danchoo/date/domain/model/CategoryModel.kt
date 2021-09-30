package com.danchoo.date.domain.model

import java.util.*


data class CategoryModel(
    val categoryId: Long = 0L,

    val hash: String = UUID.randomUUID().toString(),

    val title: String = "",

    val description: String = "",

    val selectCount: Long = 0L,

    val createTimestamp: Long = 0L,

    val lastModifiedTimestamp: Long = 0L,

    val lastVisitTimestamp: Long = 0L,

    val lastContentsModifiedTimestamp: Long = 0L,

    val tagGroupList: List<TagGroupModel> = emptyList(),

    val tagList: List<TagModel> = emptyList(),

    val visibility: Int = 0,

    var totalCount: Long = 0L,

    val revision: Long = 0
)
