package com.danchoo.date.domain.model

import java.util.*

sealed class ContentsModel {
    data class ContentsData(
        val contentsId: Long = 0L,

        val categoryId: Long = 0L,

        val hash: String = UUID.randomUUID().toString(),

        val title: String = "",

        val contentsIdList: List<Long> = emptyList(),

        val selectCount: Long = 0L,

        val createTimestamp: Long = 0,

        val lastModifiedTimestamp: Long = 0L,

        val lastVisitTimestamp: Long = 0L,

        val tagGroupIdList: List<Long> = emptyList(),

        val tagIdList: List<Long> = emptyList(),

        val visibility: Int = 0,

        val share: Int = 0,

        var revision: Long = 0
    ) : ContentsModel()

    data class ContentsHeader(val title: String) : ContentsModel()
}