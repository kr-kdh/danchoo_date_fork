package com.danchoo.category.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.danchoo.category.data.db.dao.CategoryDao
import com.danchoo.category.data.db.entity.Category
import com.danchoo.category.data.db.entity.CategoryTagGroupInfo
import com.danchoo.category.data.db.entity.CategoryTagInfo
import com.danchoo.tags.data.db.entiry.Tag
import com.danchoo.tags.data.db.entiry.TagGroup

@Database(
    entities = [
        Category::class,
        Tag::class,
        TagGroup::class,
        CategoryTagGroupInfo::class,
        CategoryTagInfo::class
    ],
    version = 1,
    exportSchema = true
)
abstract class TestAppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
}