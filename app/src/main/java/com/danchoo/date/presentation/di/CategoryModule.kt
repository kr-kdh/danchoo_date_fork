package com.danchoo.date.presentation.di

import com.danchoo.date.data.datasource.local.CategoryLocalDataSource
import com.danchoo.date.data.datasource.local.CategoryLocalDataSourceImpl
import com.danchoo.date.data.datasource.pagingsource.CategoryPagingSource
import com.danchoo.date.data.datasource.remote.CategoryRemoteDataSource
import com.danchoo.date.data.datasource.remote.CategoryRemoteDataSourceImpl
import com.danchoo.date.data.db.dao.CategoryDao
import com.danchoo.date.data.repository.CategoryRepositoryImpl
import com.danchoo.date.domain.inspactor.usecase.main.category.CategoryListInsertUseCase
import com.danchoo.date.domain.inspactor.usecase.main.category.CategoryPagingUseCase
import com.danchoo.date.domain.repository.CategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CategoryModule {

    @Provides
    fun provideCategoryPagingUseCase(repository: CategoryRepository): CategoryPagingUseCase {
        return CategoryPagingUseCase(repository)
    }

    @Provides
    fun provideCategoryListInsertUseCase(
        repository: CategoryRepository,
        dispatcher: CoroutineDispatcher
    ): CategoryListInsertUseCase {
        return CategoryListInsertUseCase(repository, dispatcher)
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
        return CategoryPagingSource(localDataSource)
    }

    @Singleton
    @Provides
    fun provideCategoryLocalDataSource(categoryDao: CategoryDao): CategoryLocalDataSource {
        return CategoryLocalDataSourceImpl(categoryDao)
    }

    @Singleton
    @Provides
    fun provideCategoryRemoteDataSource(): CategoryRemoteDataSource {
        return CategoryRemoteDataSourceImpl()
    }
}