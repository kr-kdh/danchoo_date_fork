package com.danchoo.category.di

import com.danchoo.category.domain.inspector.manager.CategoryUseCaseManager
import com.danchoo.category.domain.inspector.manager.impl.CategoryUseCaseManagerImpl
import com.danchoo.category.domain.inspector.usecase.CategoryCreateUseCase
import com.danchoo.category.domain.repository.CategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CategoryUseCaseModule {

    @Singleton
    @Provides
    fun provideCategoryUseCaseManager(
        categoryCreateUseCase: CategoryCreateUseCase
    ): CategoryUseCaseManager {
        return CategoryUseCaseManagerImpl(categoryCreateUseCase)
    }

    @Provides
    fun provideCategoryCreateUseCase(
        repository: CategoryRepository,
        dispatcher: CoroutineDispatcher
    ): CategoryCreateUseCase {
        return CategoryCreateUseCase(repository, dispatcher)
    }
}