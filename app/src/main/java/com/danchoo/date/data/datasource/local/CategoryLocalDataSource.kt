package com.danchoo.date.data.datasource.local

import androidx.paging.PagingSource
import com.danchoo.date.data.db.entity.Category

interface CategoryLocalDataSource {

    fun getCategoryList(
        timestamp: Long,
        size: Int
    ): List<Category>

    fun getCategoryList(): PagingSource<Int, Category>

    fun getTimestampByOffset(offset: Int): Long?

    fun insertCategoryList(categoryList: List<Category>)
}