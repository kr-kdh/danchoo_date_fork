package com.danchoo.date.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.danchoo.date.data.db.dao.CategoryDao
import com.danchoo.date.data.db.dao.ContentsDao
import com.danchoo.date.data.db.entity.*

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