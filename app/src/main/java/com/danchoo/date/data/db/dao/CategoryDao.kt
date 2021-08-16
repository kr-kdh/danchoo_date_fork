package com.danchoo.date.data.db.dao

import androidx.paging.Pager
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.danchoo.date.data.db.entity.Category
import com.danchoo.date.data.pagingsource.CategoryPagingSource

@Dao
abstract class CategoryDao {

    @Transaction
    @Query(
        """ 
            SELECT * 
            FROM category 
            WHERE timestamp >= :timestamp 
            ORDER BY timestamp ASC 
            LIMIT :size"""
    )
    abstract fun getCategoryList(
        timestamp: Long,
        size: Int
    ): List<Category>

    @Transaction
    @Query(
        """ 
            SELECT timestamp 
            FROM category 
            ORDER BY timestamp ASC 
            LIMIT 1 OFFSET :offset"""
    )
    abstract fun getTimestampByOffset(
        offset: Int
    ): Long?

    @Insert
    abstract fun insertAll(list: List<Category>)
}