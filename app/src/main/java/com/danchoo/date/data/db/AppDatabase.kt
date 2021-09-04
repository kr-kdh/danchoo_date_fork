package com.danchoo.date.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.danchoo.date.data.db.dao.CategoryDao
import com.danchoo.date.data.db.dao.ContentsDao
import com.danchoo.date.data.db.entity.Category
import com.danchoo.date.data.db.entity.Contents

@Database(
    entities = [
        Category::class,
        Contents::class
    ],
    version = DBSettings.VERSION,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun contentsDao(): ContentsDao
}