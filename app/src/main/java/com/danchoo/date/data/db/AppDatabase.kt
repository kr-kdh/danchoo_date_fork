package com.danchoo.date.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.danchoo.date.data.db.dao.CategoryDao
import com.danchoo.date.data.db.entity.Category

@Database(
    entities = [
        Category::class
    ],
    version = DBSettings.VERSION,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
}