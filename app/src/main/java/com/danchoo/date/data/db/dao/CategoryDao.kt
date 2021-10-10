package com.danchoo.date.data.db.dao

import androidx.paging.PagingSource
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.danchoo.date.data.db.entity.Category
import com.danchoo.date.data.db.entity.CategoryInfo

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
    ): List<CategoryInfo>

    @Transaction
    @Query(
        """ 
            SELECT * 
            FROM category 
            ORDER BY create_time_stamp ASC 
            """
    )
    abstract fun getCategoryList(): PagingSource<Int, CategoryInfo>

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

    @Insert(onConflict = REPLACE)
    abstract fun insert(category: Category)

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
        SET select_count = :selectCount,
            last_visit_timestamp = :lastVisitTimestamp
        WHERE category_id == :categoryId
    """
    )
    abstract fun updateSelectCount(
        categoryId: Long,
        selectCount: Long,
        lastVisitTimestamp: Long
    )

    @Query("delete from category where category_id = :categoryId")
    abstract fun delete(categoryId: Long)

    @Query("delete from category")
    abstract fun deleteAll()
}