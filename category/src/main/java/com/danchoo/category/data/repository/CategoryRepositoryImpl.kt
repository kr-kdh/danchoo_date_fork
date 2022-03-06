package com.danchoo.category.data.repository

import android.net.Uri
import com.danchoo.category.data.datasource.local.CategoryLocalDataSource
import com.danchoo.category.data.datasource.pagingsource.CategoryPagingSource
import com.danchoo.category.data.datasource.remote.CategoryRemoteDataSource
import com.danchoo.category.data.mapper.toEntity
import com.danchoo.category.data.mapper.toModel
import com.danchoo.category.domain.model.CategoryModel
import com.danchoo.category.domain.repository.CategoryRepository

class CategoryRepositoryImpl constructor(
    private val localDataSource: CategoryLocalDataSource,
    private val remoteDataSource: CategoryRemoteDataSource
) : CategoryRepository {
    override fun getCategoryCustomPagingSource(): CategoryPagingSource {
        return CategoryPagingSource(
            localDataSource
        )
    }

    override fun getCategoryList(): List<CategoryModel> {
        return localDataSource.getCategoryList().map { it.toModel() }
    }

    override suspend fun createCategory(
        title: String,
        description: String,
        visibility: Int,
        coverImageUri: Uri,
        currentTimestamp: Long
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
            visibility = visibility,
            coverImageUri = coverImageUri.toString(),
            createTimestamp = currentTimestamp,
            lastModifiedTimestamp = currentTimestamp
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
        readCount: Long,
        lastReadTimestamp: Long
    ) {
        localDataSource.updateReadCount(
            categoryId = categoryId,
            readCount = readCount,
            lastReadTimestamp = lastReadTimestamp
        )
    }

    override fun deleteCategory(categoryId: Long) {
        localDataSource.delete(categoryId)
    }

    override fun getCategoryFolderPath(): String = localDataSource.getCategoryFolderPath()
}