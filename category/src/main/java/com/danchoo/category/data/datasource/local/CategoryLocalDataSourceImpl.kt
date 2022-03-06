package com.danchoo.category.data.datasource.local

import android.content.Context
import androidx.paging.PagingSource
import com.danchoo.category.data.db.dao.CategoryDao
import com.danchoo.category.data.db.entity.Category
import com.danchoo.category.data.db.entity.CategoryInfo
import com.danchoo.commonutils.extension.getCacheDirByName
import dagger.hilt.android.qualifiers.ApplicationContext

class CategoryLocalDataSourceImpl constructor(
    @ApplicationContext private val context: Context,
    private val categoryDao: CategoryDao
) : CategoryLocalDataSource {
    override fun getCategoryFolderPath() =
        context.getCacheDirByName(CATEGORY_PATH).absolutePath ?: ""

    override fun getCategoryList(): List<Category> {
        return categoryDao.getCategoryList()
    }

    override fun getCategoryInfoList(timestamp: Long, size: Int): List<CategoryInfo> {
        return categoryDao.getCategoryInfoList(timestamp, size)
    }

    override fun getCategoryInfoList(): List<CategoryInfo> {
        return categoryDao.getCategoryInfoList()
    }

    override fun getCategoryPagingSource(): PagingSource<Int, CategoryInfo> {
        return categoryDao.getCategoryPagingSource()
    }

    override fun getCategory(categoryId: Long): Category? {
        return categoryDao.getCategory(categoryId)
    }

    override fun getCreateTimestampByOffset(offset: Int): Long? {
        return categoryDao.getCreateTimestampByOffset(offset)
    }

    override fun insert(category: Category): Long {
        return categoryDao.insert(category)
    }

    override fun update(category: Category) {
        categoryDao.update(category)
    }

    override fun update(
        categoryId: Long,
        title: String,
        description: String,
        visibility: Int,
        lastModifiedTimestamp: Long
    ) {
        categoryDao.update(
            categoryId = categoryId,
            title = title,
            description = description,
            visibility = visibility,
            lastModifiedTimestamp = lastModifiedTimestamp
        )
    }

    override fun updateReadCount(
        categoryId: Long,
        readCount: Long,
        lastReadTimestamp: Long
    ) {
        categoryDao.updateReadCount(
            categoryId = categoryId,
            readCount = readCount,
            lastReadTimestamp = lastReadTimestamp
        )
    }

    override fun delete(categoryId: Long) {
        categoryDao.delete(categoryId)
    }

    override fun deleteAll() {
        categoryDao.deleteAll()
    }

    companion object {
        private const val CATEGORY_PATH = "category"
    }
}