package com.danchoo.date.domain.repository

import com.danchoo.date.data.pagingsource.CategoryPagingSource
import com.danchoo.date.domain.model.CategoryModel
import com.danchoo.date.domain.model.constants.Visibility

interface CategoryRepository {
    fun getCategoryCustomPagingSource(): CategoryPagingSource

    fun createCategory(
        title: String,
        description: String,
        visibility: Visibility = Visibility.Visible
    )

    fun updateCategory(categoryModel: CategoryModel)

    fun updateCategory(
        categoryId: Long,
        title: String,
        description: String,
        visibility: Visibility
    )

    fun deleteCategory(categoryId: Long)
}