package com.danchoo.date.domain.model.extension

import com.danchoo.date.data.db.entity.Category
import com.danchoo.date.domain.model.CategoryModel

fun CategoryModel.CategoryData.toEntity(): Category {
    return Category(categoryId, title, contents, timestamp, revision)
}
