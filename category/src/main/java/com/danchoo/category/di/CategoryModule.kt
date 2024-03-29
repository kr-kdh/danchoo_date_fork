package com.danchoo.category.di

import android.content.Context
import com.danchoo.category.data.datasource.local.CategoryLocalDataSource
import com.danchoo.category.data.datasource.local.CategoryLocalDataSourceImpl
import com.danchoo.category.data.datasource.pagingsource.CategoryPagingSource
import com.danchoo.category.data.datasource.remote.CategoryRemoteDataSource
import com.danchoo.category.data.datasource.remote.FakeCategoryRemoteDataSourceImpl
import com.danchoo.category.data.db.dao.CategoryDao
import com.danchoo.category.data.repository.CategoryRepositoryImpl
import com.danchoo.category.domain.repository.CategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CategoryModule {

    @Singleton
    @Provides
    fun provideCategoryRepository(
        localDataSource: CategoryLocalDataSource,
        remoteDataSource: CategoryRemoteDataSource
    ): CategoryRepository {
        return CategoryRepositoryImpl(localDataSource, remoteDataSource)
    }

    @Provides
    fun provideCategoryPagingSource(localDataSource: CategoryLocalDataSource): CategoryPagingSource {
        return CategoryPagingSource(
            localDataSource
        )
    }

    @Singleton
    @Provides
    fun provideCategoryLocalDataSource(
        @ApplicationContext context: Context,
        categoryDao: CategoryDao
    ): CategoryLocalDataSource {
        return CategoryLocalDataSourceImpl(context, categoryDao)
    }

//    @Singleton
//    @Provides
//    fun provideCategoryRemoteDataSource(apiInterface: CategoryApiInterface): CategoryRemoteDataSource {
//        return CategoryRemoteDataSourceImpl(apiInterface)
//    }

    @Singleton
    @Provides
    fun provideCategoryRemoteDataSource(): CategoryRemoteDataSource {
        return FakeCategoryRemoteDataSourceImpl()
    }
}