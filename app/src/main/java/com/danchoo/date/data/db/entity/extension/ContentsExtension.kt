package com.danchoo.date.data.db.entity.extension

import com.danchoo.date.data.db.entity.Contents
import com.danchoo.date.domain.model.ContentsModel


fun Contents.toModel(source: ContentsModel.ContentsData? = null): ContentsModel {
    return source?.copy(
        contentsId = hash,
        title = title,
        contents = contents,
        timestamp = timestamp,
        revision = revision
    ) ?: kotlin.run {
        ContentsModel.ContentsData(
            contentsId = hash,
            title = title,
            contents = contents,
            timestamp = timestamp,
            revision = revision
        )
    }
}