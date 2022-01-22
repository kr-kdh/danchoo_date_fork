package com.danchoo.contents.domain.model.extension

import com.danchoo.contents.data.db.entity.Contents
import com.danchoo.contents.domain.model.ContentsModel


fun Contents.toModel(): ContentsModel {
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
