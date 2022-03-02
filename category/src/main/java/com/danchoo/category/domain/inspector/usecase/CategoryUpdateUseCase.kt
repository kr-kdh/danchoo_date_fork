package com.danchoo.category.domain.inspector.usecase

import com.danchoo.category.domain.repository.CategoryRepository
import com.danchoo.common.usecase.UseCase
import kotlinx.coroutines.CoroutineDispatcher

class CategoryUpdateUseCase(
    private val repository: CategoryRepository,
    coroutineDispatcher: CoroutineDispatcher
) : UseCase<Unit, Unit>(coroutineDispatcher) {

    override suspend fun execute(parameters: Unit) {
        TODO("Not yet implemented")
    }
}