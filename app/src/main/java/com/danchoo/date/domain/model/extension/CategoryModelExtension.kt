package com.danchoo.date.domain.model.extension

import com.danchoo.date.data.db.entity.Category
import com.danchoo.date.domain.model.CategoryModel

fun CategoryModel.CategoryData.toEntity(): Category {
    return Category(
        categoryId = categoryId,
        hash = hash,
        title = title,
        description = description,
        lastModifiedTimestamp = lastModifiedTimestamp,
        revision = revision
    )
}
