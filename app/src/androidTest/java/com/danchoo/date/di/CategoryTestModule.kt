package com.danchoo.date.di

import com.danchoo.date.data.datasource.local.CategoryLocalDataSource
import com.danchoo.date.data.datasource.local.CategoryLocalDataSourceImpl
import com.danchoo.date.data.datasource.pagingsource.CategoryPagingSource
import com.danchoo.date.data.db.dao.CategoryDao
import com.danchoo.date.data.repository.CategoryRepositoryImpl
import com.danchoo.date.domain.inspactor.usecase.main.category.CategoryListInsertUseCase
import com.danchoo.date.domain.inspactor.usecase.main.category.CategoryPagingUseCase
import com.danchoo.date.domain.repository.CategoryRepository
import com.danchoo.date.presentation.di.CategoryModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [CategoryModule::class]
)
object CategoryTestModule {

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
        localDatasource: CategoryLocalDataSource
    ): CategoryRepository {
        return CategoryRepositoryImpl(localDatasource)
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
}