package com.danchoo.contents.data.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.danchoo.contents.data.db.entity.Contents

@Dao
abstract class ContentsDao {

    @Transaction
    @Query(
        """ 
            SELECT * 
            FROM contents 
            WHERE create_time_stamp >= :timestamp 
            ORDER BY create_time_stamp ASC 
            LIMIT :size"""
    )
    abstract fun getContentsList(
        timestamp: Long,
        size: Int
    ): List<Contents>

    @Transaction
    @Query(
        """ 
            SELECT * 
            FROM contents 
            WHERE category_id = :categoryId
            ORDER BY create_time_stamp ASC 
            """
    )
    abstract fun getContentsList(categoryId: Long): PagingSource<Int, Contents>

    @Transaction
    @Query(
        """ 
            SELECT create_time_stamp 
            FROM contents 
            WHERE category_id = :categoryId
            ORDER BY create_time_stamp ASC 
            LIMIT 1 OFFSET :offset"""
    )
    abstract fun getTimestampByOffset(
        categoryId: Long,
        offset: Int
    ): Long?

    @Insert
    abstract fun insertAll(list: List<Contents>)
}