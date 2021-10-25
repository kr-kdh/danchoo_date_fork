package com.danchoo.date.presentation.di

import com.danchoo.category.data.datasource.local.CategoryLocalDataSource
import com.danchoo.category.data.datasource.local.CategoryLocalDataSourceImpl
import com.danchoo.category.data.datasource.pagingsource.CategoryPagingSource
import com.danchoo.category.data.datasource.remote.CategoryRemoteDataSource
import com.danchoo.category.data.datasource.remote.CategoryRemoteDataSourceImpl
import com.danchoo.category.data.db.dao.CategoryDao
import com.danchoo.category.data.repository.CategoryRepositoryImpl
import com.danchoo.category.domain.inspactor.usecase.CategoryPagingUseCase
import com.danchoo.category.domain.repository.CategoryRepository
import com.danchoo.date.presentation.di.NetworkModule.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CategoryModule {

    @Provides
    fun provideCategoryPagingUseCase(repository: CategoryRepository): CategoryPagingUseCase {
        return CategoryPagingUseCase(repository)
    }

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
    fun provideCategoryLocalDataSource(categoryDao: CategoryDao): CategoryLocalDataSource {
        return CategoryLocalDataSourceImpl(categoryDao)
    }

    @Singleton
    @Provides
    fun provideCategoryRemoteDataSource(apiInterface: ApiInterface): CategoryRemoteDataSource {
        return CategoryRemoteDataSourceImpl(apiInterface)
    }
}