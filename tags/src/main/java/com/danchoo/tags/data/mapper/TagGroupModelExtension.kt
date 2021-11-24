package com.danchoo.tags.data.mapper

import com.danchoo.tags.data.db.entiry.TagGroup
import com.danchoo.tags.domain.model.TagGroupModel


fun TagGroup.toModel(): TagGroupModel {
    return TagGroupModel(
        groupId = groupId,
        hash = hash,
        title = title,
        createTimestamp = createTimestamp,
        visibility = visibility,
        selectCount = selectCount
    )
}

fun TagGroupModel.toEntity(): TagGroup {
    return TagGroup(
        groupId = groupId,
        hash = hash,
        title = title,
        createTimestamp = createTimestamp,
        visibility = visibility,
        selectCount = selectCount
    )
}