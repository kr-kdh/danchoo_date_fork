package com.danchoo.date.domain.model

import java.util.*

sealed class CategoryModel {
    data class CategoryData(
        val categoryId: Long = 0L,

        val hash: String = UUID.randomUUID().toString(),

        val title: String = "",

        val description: String = "",

        val selectCount: Long = 0L,

        val createTimestamp: Long = 0L,

        val lastModifiedTimestamp: Long = 0L,

        val lastVisitTimestamp: Long = 0L,

        val tagGroupIdList: List<Long> = emptyList(),

        val tagIdList: List<Long> = emptyList(),

        val visibility: Int = 0,

        val revision: Long = 0
    ) : CategoryModel() {
        var lastContentsModifiedTimestamp: Long = 0L
        var totalCount: Long = 0L
    }

    data class CategoryHeader(val title: String) : CategoryModel()
}

