package com.danchoo.date.domain.repository

import com.danchoo.date.data.pagingsource.CategoryPagingSource
import com.danchoo.date.domain.model.CategoryModel

interface CategoryRepository {
    fun getCategoryPagingSource(): CategoryPagingSource

    fun insertCategory(categoryList: List<CategoryModel>)
}