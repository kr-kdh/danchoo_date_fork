package com.danchoo.date.data.datasource.local

import androidx.paging.PagingSource
import com.danchoo.date.data.db.dao.CategoryDao
import com.danchoo.date.data.db.entity.Category

class CategoryLocalDataSourceImpl internal constructor(
    private val categoryDao: CategoryDao
) : CategoryLocalDataSource {

    override fun getCategoryList(timestamp: Long, size: Int): List<Category> {
        return categoryDao.getCategoryList(timestamp, size)
    }

    override fun getCategoryList(): PagingSource<Int, Category> {
        return categoryDao.getCategoryList()
    }


    override fun getTimestampByOffset(offset: Int): Long? {
        return categoryDao.getTimestampByOffset(offset)
    }

    override fun insertCategoryList(categoryList: List<Category>) {
        categoryDao.insertAll(categoryList)
    }
}