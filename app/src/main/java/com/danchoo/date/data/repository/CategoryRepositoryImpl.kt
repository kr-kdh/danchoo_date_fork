package com.danchoo.date.data.repository

import com.danchoo.commonutils.TimeUtils
import com.danchoo.date.data.datasource.local.CategoryLocalDataSource
import com.danchoo.date.data.pagingsource.CategoryPagingSource
import com.danchoo.date.domain.model.CategoryData
import com.danchoo.date.domain.model.CategoryModel
import com.danchoo.date.domain.model.constants.Visibility
import com.danchoo.date.domain.repository.CategoryRepository

class CategoryRepositoryImpl constructor(
    private val localDataSource: CategoryLocalDataSource,
) : CategoryRepository {
    override fun getCategoryCustomPagingSource(): CategoryPagingSource {
        return CategoryPagingSource(localDataSource)
    }

    override fun createCategory(title: String, description: String, visibility: Visibility) {
        val categoryModel = CategoryModel(
            title = title,
            description = description,
            visibility = visibility.visibility,
            createTimestamp = TimeUtils.getCurrentRealTimestamp(),
            lastModifiedTimestamp = TimeUtils.getCurrentRealTimestamp()
        )
    }

    override fun updateCategory(categoryData: CategoryData) {
        TODO("Not yet implemented")
    }

    override fun updateCategory(
        categoryId: Long,
        title: String,
        description: String,
        visibility: Visibility
    ) {
        TODO("Not yet implemented")
    }

    override fun deleteCategory(categoryId: Long) {
        TODO("Not yet implemented")
    }
}