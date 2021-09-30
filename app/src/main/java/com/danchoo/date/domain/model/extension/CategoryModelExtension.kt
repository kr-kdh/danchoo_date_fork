package com.danchoo.date.domain.model.extension

import com.danchoo.date.data.db.entity.Category
import com.danchoo.date.domain.model.CategoryModel

fun Category.toModel(): CategoryModel {
    return CategoryModel.CategoryData(
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
        tagGroupIdList = tagGroupIdList,
        tagIdList = tagIdList,
        visibility = visibility,
        revision = revision
    )
}

fun CategoryModel.CategoryData.toEntity(): Category {
    return Category(
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
        tagGroupIdList = tagGroupIdList,
        tagIdList = tagIdList,
        visibility = visibility,
        revision = revision
    )
}
