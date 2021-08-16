package com.danchoo.date.domain.model.extension

import com.danchoo.date.data.db.entity.Category
import com.danchoo.date.domain.model.CategoryModel

fun CategoryModel.toEntity(): Category {
    return Category(hash, title, contents, timestamp, revision)
}
