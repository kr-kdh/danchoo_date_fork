package com.danchoo.date.domain.model.extension

import com.danchoo.date.data.db.entity.TagGroup
import com.danchoo.date.domain.model.TagGroupModel


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