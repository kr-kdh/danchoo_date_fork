package com.danchoo.date.data.db.entity.extension

import com.danchoo.date.data.db.entity.Category
import com.danchoo.date.domain.model.CategoryModel


fun Category.toModel(source: CategoryModel.CategoryData? = null): CategoryModel {
    return source?.copy(
        categoryId = categoryId,
        hash = hash,
        title = title,
        description = description,
        lastModifiedTimestamp = lastModifiedTimestamp,
        revision = revision
    ) ?: kotlin.run {
        CategoryModel.CategoryData(
            categoryId = categoryId,
            hash = hash,
            title = title,
            description = description,
            lastModifiedTimestamp = lastModifiedTimestamp,
            revision = revision
        )
    }
}