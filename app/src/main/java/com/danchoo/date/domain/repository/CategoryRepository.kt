package com.danchoo.date.domain.repository

import androidx.paging.PagingSource
import com.danchoo.date.data.db.entity.Category
import com.danchoo.date.data.pagingsource.CategoryPagingSource
import com.danchoo.date.domain.model.CategoryModel

interface CategoryRepository {
    fun getCategoryPagingSource(): PagingSource<Int, Category>

    fun getCategoryCustomPagingSource(): CategoryPagingSource

    fun insertCategory(categoryList: List<CategoryModel>)
}