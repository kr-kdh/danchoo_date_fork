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

    fun getCategory(categoryId: Long): Category?

    fun getCreateTimestampByOffset(offset: Int): Long?

    fun insert(category: Category): Long

    fun update(category: Category)

    fun update(
        categoryId: Long,
        title: String,
        description: String,
        visibility: Int,
        lastModifiedTimestamp: Long
    )

    fun updateSelectCount(
        categoryId: Long,
        selectCount: Long,
        lastVisitTimestamp: Long
    )

    fun delete(categoryId: Long)

    fun deleteAll()
}