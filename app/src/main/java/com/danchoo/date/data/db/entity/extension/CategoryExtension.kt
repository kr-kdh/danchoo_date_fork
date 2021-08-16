package com.danchoo.date.data.db.entity.extension

import com.danchoo.date.data.db.entity.Category
import com.danchoo.date.domain.model.CategoryModel


fun Category.toModel(source: CategoryModel.CategoryData? = null): CategoryModel {
    return source?.copy(
        hash = hash,
        title = title,
        contents = contents,
        timestamp = timestamp,
        revision = revision
    ) ?: kotlin.run {
        CategoryModel.CategoryData(
            hash = hash,
            title = title,
            contents = contents,
            timestamp = timestamp,
            revision = revision
        )
    }
}