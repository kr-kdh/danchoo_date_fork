package com.danchoo.category.data.db.dao

import androidx.paging.PagingSource
import androidx.room.*
import com.danchoo.category.data.db.entity.Category
import com.danchoo.category.data.db.entity.CategoryInfo

@Dao
abstract class CategoryDao {

    @Query("SELECT * FROM category ORDER BY category_id ASC")
    abstract fun getCategoryList(): List<Category>

    @Transaction
    @Query(
        """ 
            SELECT * 
            FROM category 
            WHERE create_time_stamp >= :timestamp 
            ORDER BY create_time_stamp ASC 
            LIMIT :size"""
    )
    abstract fun getCategoryInfoList(
        timestamp: Long,
        size: Int
    ): List<CategoryInfo>

    @Transaction
    @Query(
        """ 
            SELECT * 
            FROM category 
            ORDER BY create_time_stamp ASC 
            """
    )
    abstract fun getCategoryInfoList(): PagingSource<Int, CategoryInfo>

    @Query("SELECT * FROM category where category_id = :categoryId")
    abstract fun getCategory(categoryId: Long): Category?

    @Transaction
    @Query(
        """ 
            SELECT create_time_stamp 
            FROM category 
            ORDER BY create_time_stamp ASC 
            LIMIT 1 OFFSET :offset"""
    )
    abstract fun getCreateTimestampByOffset(
        offset: Int
    ): Long?

    @Insert
    abstract fun insertAll(list: List<Category>)

    @Insert
    abstract fun insert(category: Category): Long

    @Update
    abstract fun update(category: Category)

    @Query(
        """
        UPDATE category
        SET title = :title,
            description = :description,
            visibility = :visibility,
            last_modified_timestamp = :lastModifiedTimestamp
        WHERE category_id == :categoryId
    """
    )
    abstract fun update(
        categoryId: Long,
        title: String,
        description: String,
        visibility: Int,
        lastModifiedTimestamp: Long
    )

    @Query(
        """
        UPDATE category
        SET read_count = :readCount,
            last_read_timestamp = :lastReadTimestamp
        WHERE category_id == :categoryId
    """
    )
    abstract fun updateReadCount(
        categoryId: Long,
        readCount: Long,
        lastReadTimestamp: Long
    )

    @Query("delete from category where category_id = :categoryId")
    abstract fun delete(categoryId: Long)

    @Query("delete from category")
    abstract fun deleteAll()
}