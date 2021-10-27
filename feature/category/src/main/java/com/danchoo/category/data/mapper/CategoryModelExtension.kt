package com.danchoo.date.domain.model.extension

import com.danchoo.category.domain.model.CategoryModel


fun com.danchoo.category.data.db.entity.Category.toModel(): CategoryModel {
    return CategoryModel(
        categoryId = categoryId,
        hash = hash,
        title = title,
        description = description,
        selectCount = selectCount,
        createTimestamp = createTimestamp,
        lastModifiedTimestamp = lastModifiedTimestamp,
        lastVisitTimestamp = lastVisitTimestamp,
        lastContentsModifiedTimestamp = lastContentsModifiedTimestamp,
        totalCount = totalCount,
        visibility = visibility,
        revision = revision
    )
}

fun CategoryModel.toEntity(): com.danchoo.category.data.db.entity.Category {
    return com.danchoo.category.data.db.entity.Category(
        categoryId = categoryId,
        hash = hash,
        title = title,
        description = description,
        selectCount = selectCount,
        createTimestamp = createTimestamp,
        lastModifiedTimestamp = lastModifiedTimestamp,
        lastVisitTimestamp = lastVisitTimestamp,
        lastContentsModifiedTimestamp = lastContentsModifiedTimestamp,
        totalCount = totalCount,
        visibility = visibility,
        revision = revision
    )
}
