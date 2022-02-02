package com.danchoo.category.di

import com.danchoo.category.domain.inspector.usecase.CategoryCreateUseCase
import com.danchoo.category.domain.inspector.usecase.CategoryPagingUseCase
import com.danchoo.category.domain.repository.CategoryRepository
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
        dispatcher: CoroutineDispatcher
    ): CategoryCreateUseCase {
        return CategoryCreateUseCase(repository, dispatcher)
    }
}