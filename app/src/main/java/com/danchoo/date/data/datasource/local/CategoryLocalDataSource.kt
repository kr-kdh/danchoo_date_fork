package com.danchoo.date.data.datasource.local

import androidx.paging.PagingSource
import com.danchoo.date.data.db.entity.Category
import com.danchoo.date.data.db.entity.CategoryInfo

interface CategoryLocalDataSource {

    fun getCategoryList(
        timestamp: Long,
        size: Int
    ): List<CategoryInfo>

    fun getCategoryList(): PagingSource<Int, CategoryInfo>

    fun getCreateTimestampByOffset(offset: Int): Long?

    fun insert(category: Category)

    fun update(category: Category)

    fun update(
        categoryId: Long,
        title: String,
        description: String,
        lastModifiedTimestamp: Long
    )

    fun updateSelectCount(
        categoryId: Long,
        selectCount: Long,
        lastVisitTimestamp: String
    )
}