package com.danchoo.date.data.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.danchoo.date.data.db.entity.Contents

@Dao
abstract class ContentsDao {

    @Transaction
    @Query(
        """ 
            SELECT * 
            FROM category 
            WHERE timestamp >= :timestamp 
            ORDER BY timestamp ASC 
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
            ORDER BY timestamp ASC 
            """
    )
    abstract fun getContentsList(): PagingSource<Int, Contents>

    @Transaction
    @Query(
        """ 
            SELECT timestamp 
            FROM contents 
            ORDER BY timestamp ASC 
            LIMIT 1 OFFSET :offset"""
    )
    abstract fun getTimestampByOffset(
        offset: Int
    ): Long?

    @Insert
    abstract fun insertAll(list: List<Contents>)
}