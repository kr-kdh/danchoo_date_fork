package com.danchoo.date.data.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.danchoo.date.data.db.entity.Category

@Dao
abstract class CategoryDao {

    @Transaction
    @Query(
        """ 
            SELECT * 
            FROM category 
            WHERE create_time_stamp >= :timestamp 
            ORDER BY create_time_stamp ASC 
            LIMIT :size"""
    )
    abstract fun getCategoryList(
        timestamp: Long,
        size: Int
    ): List<Category>

    @Transaction
    @Query(
        """ 
            SELECT * 
            FROM category 
            ORDER BY create_time_stamp ASC 
            """
    )
    abstract fun getCategoryList(): PagingSource<Int, Category>

    @Transaction
    @Query(
        """ 
            SELECT create_time_stamp 
            FROM category 
            ORDER BY create_time_stamp ASC 
            LIMIT 1 OFFSET :offset"""
    )
    abstract fun getTimestampByOffset(
        offset: Int
    ): Long?

    @Insert
    abstract fun insertAll(list: List<Category>)
}