package com.danchoo.date.domain.model.extension

import com.danchoo.date.data.db.entity.Contents
import com.danchoo.date.domain.model.ContentsModel

fun ContentsModel.ContentsData.toEntity(): Contents {
    return Contents(contentsId, title, contents, timestamp, revision)
}
