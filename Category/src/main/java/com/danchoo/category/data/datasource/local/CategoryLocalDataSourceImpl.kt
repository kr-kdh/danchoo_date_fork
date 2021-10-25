package com.danchoo.category.data.datasource.local

import androidx.paging.PagingSource
import com.danchoo.category.data.db.dao.CategoryDao
import com.danchoo.category.data.db.entity.Category
import com.danchoo.category.data.db.entity.CategoryInfo

class CategoryLocalDataSourceImpl constructor(
    private val categoryDao: CategoryDao
) : CategoryLocalDataSource {

    override fun getCategoryList(timestamp: Long, size: Int): List<CategoryInfo> {
        return categoryDao.getCategoryList(timestamp, size)
    }

    override fun getCategoryList(): PagingSource<Int, CategoryInfo> {
        return categoryDao.getCategoryList()
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

    override fun updateSelectCount(
        categoryId: Long,
        selectCount: Long,
        lastVisitTimestamp: Long
    ) {
        categoryDao.updateSelectCount(
            categoryId = categoryId,
            selectCount = selectCount,
            lastVisitTimestamp = lastVisitTimestamp
        )
    }

    override fun delete(categoryId: Long) {
        categoryDao.delete(categoryId)
    }

    override fun deleteAll() {
        categoryDao.deleteAll()
    }
}