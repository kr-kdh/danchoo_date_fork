package com.danchoo.date.domain.model.extension

import com.danchoo.date.data.db.entity.Contents
import com.danchoo.date.domain.model.ContentsModel


fun Contents.toModel(source: ContentsModel.ContentsData? = null): ContentsModel {
    return ContentsModel.ContentsData(
        contentsId = contentsId,
        categoryId = categoryId,
        hash = hash,
        title = title,
        creator = creator,
        contentsIdList = contentsIdList,
        selectCount = selectCount,
        createTimestamp = createTimestamp,
        lastVisitTimestamp = lastVisitTimestamp,
        tagGroupIdList = tagGroupIdList,
        tagIdList = tagIdList,
        visibility = visibility,
        share = share,
        revision = revision
    )
}

fun ContentsModel.ContentsData.toEntity(): Contents {
    return Contents(
        contentsId = contentsId,
        categoryId = categoryId,
        hash = hash,
        title = title,
        creator = creator,
        contentsIdList = contentsIdList,
        selectCount = selectCount,
        createTimestamp = createTimestamp,
        lastVisitTimestamp = lastVisitTimestamp,
        tagGroupIdList = tagGroupIdList,
        tagIdList = tagIdList,
        visibility = visibility,
        share = share,
        revision = revision
    )
}
