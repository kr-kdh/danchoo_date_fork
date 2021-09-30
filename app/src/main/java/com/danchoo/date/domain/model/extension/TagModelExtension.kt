package com.danchoo.date.domain.model.extension

import com.danchoo.date.data.db.entity.Tag
import com.danchoo.date.domain.model.TagModel

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