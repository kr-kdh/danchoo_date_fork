package com.danchoo.date.presentation.di

import android.content.Context
import androidx.room.Room
import com.danchoo.category.data.db.dao.CategoryDao
import com.danchoo.contents.data.db.dao.ContentsDao
import com.danchoo.date.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, "Date.db")
            .build()
    }

    @Provides
    @Singleton
    fun provideCategoryDao(appDatabase: AppDatabase): CategoryDao {
        return appDatabase.categoryDao()
    }

    @Provides
    @Singleton
    fun provideContentsDao(appDatabase: AppDatabase): ContentsDao {
        return appDatabase.contentsDao()
    }
}