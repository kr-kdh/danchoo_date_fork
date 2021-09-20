package com.danchoo.date.data.repository

import com.danchoo.date.data.datasource.local.CategoryLocalDataSource
import com.danchoo.date.data.pagingsource.CategoryPagingSource
import com.danchoo.date.domain.model.CategoryModel
import com.danchoo.date.domain.model.extension.toEntity
import com.danchoo.date.domain.repository.CategoryRepository

class CategoryRepositoryImpl constructor(
    private val localDataSource: CategoryLocalDataSource,
) : CategoryRepository {
    override fun getCategoryCustomPagingSource(): CategoryPagingSource {
        return CategoryPagingSource(localDataSource)
    }

    override fun insertCategory(categoryList: List<CategoryModel>) {
        val list = categoryList
            .asSequence()
            .filter { it is CategoryModel.CategoryData }
            .map {
                (it as CategoryModel.CategoryData).toEntity()
            }.toList()
        localDataSource.insertCategoryList(list)
    }
}