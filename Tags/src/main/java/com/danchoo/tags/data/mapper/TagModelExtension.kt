package com.danchoo.tags.data.mapper

import com.danchoo.tags.data.db.entiry.Tag
import com.danchoo.tags.domain.model.TagModel

fun Tag.toModel(): TagModel {
    return TagModel(
        tagId = tagId,
        hash = hash,
        groupId = groupId,
        tag = tag,
        createTimestamp = createTimestamp,
        visibility = visibility,
        selectCount = selectCount
    )
}

fun TagModel.toEntity(): Tag {
    return Tag(
        tagId = tagId,
        hash = hash,
        groupId = groupId,
        tag = tag,
        createTimestamp = createTimestamp,
        visibility = visibility,
        selectCount = selectCount
    )
}