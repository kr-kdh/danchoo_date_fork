package com.danchoo.date.data.datasource.local

import com.danchoo.date.data.db.entity.Category

interface CategoryLocalDataSource {

    fun getCategoryList(
        timestamp: Long,
        size: Int
    ): List<Category>

    fun getTimestampByOffset(offset: Int): Long?

    fun insertCategoryList(categoryList: List<Category>)
}