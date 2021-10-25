package com.danchoo.tags.domain.model

data class TagGroupModel(
    val groupId: Long,

    val hash: String,

    val title: String,

    val createTimestamp: Long,

    val visibility: Int = 0,

    val selectCount: Long
)
