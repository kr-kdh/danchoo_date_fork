package com.danchoo.category.data.mapper

import com.danchoo.category.domain.model.CategoryModel


fun com.danchoo.category.data.db.entity.Category.toModel(): CategoryModel {
    return CategoryModel(
        categoryId = categoryId,
        hash = hash,
        title = title,
        description = description,
        coverImageUri = coverUriImage,
        readCount = readCount,
        createTimestamp = createTimestamp,
        lastModifiedTimestamp = lastModifiedTimestamp,
        lastReadTimestamp = lastReadTimestamp,
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
        coverUriImage = coverImageUri,
        readCount = readCount,
        createTimestamp = createTimestamp,
        lastModifiedTimestamp = lastModifiedTimestamp,
        lastReadTimestamp = lastReadTimestamp,
        lastContentsModifiedTimestamp = lastContentsModifiedTimestamp,
        totalCount = totalCount,
        visibility = visibility,
        revision = revision
    )
}
