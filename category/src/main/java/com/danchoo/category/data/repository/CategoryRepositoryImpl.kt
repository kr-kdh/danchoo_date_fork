package com.danchoo.category.data.repository

import com.danchoo.category.data.datasource.local.CategoryLocalDataSource
import com.danchoo.category.data.datasource.pagingsource.CategoryPagingSource
import com.danchoo.category.data.datasource.remote.CategoryRemoteDataSource
import com.danchoo.category.domain.model.CategoryModel
import com.danchoo.category.domain.repository.CategoryRepository
import com.danchoo.date.domain.model.extension.toEntity

class CategoryRepositoryImpl constructor(
    private val localDataSource: CategoryLocalDataSource,
    private val remoteDataSource: CategoryRemoteDataSource
) : CategoryRepository {
    override fun getCategoryCustomPagingSource(): CategoryPagingSource {
        return CategoryPagingSource(
            localDataSource
        )
    }

    override suspend fun createCategory(
        title: String,
        description: String,
        visibility: Int
    ): CategoryModel? {

        val response = remoteDataSource.requestCreateCategory(
            title = title,
            description = description,
            visibility = visibility
        )

        if (!response.result) {
            return null
        }

        val categoryModel = CategoryModel(
            title = title,
            description = description,
            visibility = visibility
//            ,
//            createTimestamp = currentTimestamp,
//            lastModifiedTimestamp = currentTimestamp
        )

        val categoryId = localDataSource.insert(categoryModel.toEntity())

        return if (categoryId > 0) {
            categoryModel.copy(categoryId = categoryId)
        } else {
            null
        }
    }

    override fun updateCategory(categoryModel: CategoryModel) {
        localDataSource.update(categoryModel.toEntity())
    }

    override fun updateCategory(
        categoryId: Long,
        title: String,
        description: String,
        visibility: Int,
        currentTimestamp: Long
    ) {
        localDataSource.update(
            categoryId = categoryId,
            title = title,
            description = description,
            visibility = visibility,
            lastModifiedTimestamp = currentTimestamp
        )
    }

    override fun updateSelectCount(
        categoryId: Long,
        selectCount: Long,
        lastVisitTimestamp: Long
    ) {
        localDataSource.updateSelectCount(
            categoryId = categoryId,
            selectCount = selectCount,
            lastVisitTimestamp = lastVisitTimestamp
        )
    }

    override fun deleteCategory(categoryId: Long) {
        localDataSource.delete(categoryId)
    }
}