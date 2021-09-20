package com.danchoo.date.data.db.entity.extension

import com.danchoo.date.data.db.entity.Contents
import com.danchoo.date.domain.model.ContentsModel


fun Contents.toModel(source: ContentsModel.ContentsData? = null): ContentsModel {
    return source?.copy(
        contentsId = contentsId,
        hash = hash,
        title = title,
        createTimestamp = createTimestamp,
        revision = revision
    ) ?: kotlin.run {
        ContentsModel.ContentsData(
            contentsId = contentsId,
            hash = hash,
            title = title,
            createTimestamp = createTimestamp,
            revision = revision
        )
    }
}