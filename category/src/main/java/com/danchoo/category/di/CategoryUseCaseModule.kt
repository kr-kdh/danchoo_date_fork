package com.danchoo.category.di

import com.danchoo.category.domain.inspector.usecase.CategoryCreateUseCase
import com.danchoo.category.domain.inspector.usecase.CategoryListInsertUseCase
import com.danchoo.category.domain.inspector.usecase.CategoryListUseCase
import com.danchoo.category.domain.inspector.usecase.CategoryPagingUseCase
import com.danchoo.category.domain.repository.CategoryRepository
import com.danchoo.commonutils.file.domain.repository.FileRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(SingletonComponent::class)
object CategoryUseCaseModule {
    @Provides
    fun provideCategoryPagingUseCase(repository: CategoryRepository): CategoryPagingUseCase {
        return CategoryPagingUseCase(repository)
    }

    @Provides
    fun provideCategoryCreateUseCase(
        repository: CategoryRepository,
        fileRepository: FileRepository,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ): CategoryCreateUseCase {
        return CategoryCreateUseCase(repository, fileRepository, dispatcher)
    }

    @Provides
    fun provideCategoryListUseCase(
        repository: CategoryRepository,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ): CategoryListUseCase {
        return CategoryListUseCase(repository, dispatcher)
    }

    @Provides
    fun provideCategoryListInsertUseCase(
        repository: CategoryRepository,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ): CategoryListInsertUseCase {
        return CategoryListInsertUseCase(repository, dispatcher)
    }
}