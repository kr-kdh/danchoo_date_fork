package com.danchoo.category.domain.repository

import com.danchoo.category.domain.model.CategoryModel

interface CategoryRepository {
    fun getCategoryCustomPagingSource(): com.danchoo.category.data.datasource.pagingsource.CategoryPagingSource

    suspend fun createCategory(
        title: String,
        description: String,
        visibility: Int = 0
    ): CategoryModel?

    fun updateCategory(categoryModel: CategoryModel)

    fun updateCategory(
        categoryId: Long,
        title: String,
        description: String,
        visibility: Int,
        currentTimestamp: Long
    )

    fun updateSelectCount(
        categoryId: Long,
        selectCount: Long,
        lastVisitTimestamp: Long
    )

    fun deleteCategory(categoryId: Long)
}