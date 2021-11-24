package com.danchoo.date.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.danchoo.category.data.db.dao.CategoryDao
import com.danchoo.category.data.db.entity.Category
import com.danchoo.category.data.db.entity.CategoryTagGroupInfo
import com.danchoo.category.data.db.entity.CategoryTagInfo
import com.danchoo.contents.data.db.dao.ContentsDao
import com.danchoo.contents.data.db.entity.Contents
import com.danchoo.date.data.db.entity.ContentsMedia
import com.danchoo.tags.data.db.entiry.Tag
import com.danchoo.tags.data.db.entiry.TagGroup

@Database(
    entities = [
        Category::class,
        Contents::class,
        Tag::class,
        TagGroup::class,
        CategoryTagGroupInfo::class,
        CategoryTagInfo::class,
        ContentsMedia::class
    ],
    version = DBSettings.VERSION,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun contentsDao(): ContentsDao
}