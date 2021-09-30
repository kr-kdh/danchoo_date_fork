package com.danchoo.date.domain.model

data class TagModel(
    val tagId: Long = 0L,

    val hash: String,

    val groupId: Long = 0L,

    val tag: String = "",

    val createTimestamp: Long = 0L,

    val visibility: Int = 0,

    val selectCount: Long = 0
)