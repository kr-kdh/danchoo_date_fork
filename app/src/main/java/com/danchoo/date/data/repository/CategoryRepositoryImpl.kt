package com.danchoo.date.data.repository

import com.danchoo.date.data.datasource.local.CategoryLocalDataSource
import com.danchoo.date.data.db.entity.Category
import com.danchoo.date.data.pagingsource.CategoryPagingSource
import com.danchoo.date.domain.model.CategoryModel
import com.danchoo.date.domain.model.extension.toEntity
import com.danchoo.date.domain.repository.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl constructor(
    private val categoryPagingSource: CategoryPagingSource,
    private val localDatasource: CategoryLocalDataSource
): CategoryRepository {
    override fun getCategoryPagingSource(): CategoryPagingSource {
        return categoryPagingSource
    }

    override fun insertCategory(categoryList: List<CategoryModel>) {
        val list = categoryList.map { it.toEntity() }
        localDatasource.insertCategoryList(list)
    }
}