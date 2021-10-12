package com.danchoo.date.domain.inspactor.usecase.main.category

import com.danchoo.date.domain.repository.CategoryRepository
import com.danchoo.inspactor.usecase.UseCase
import kotlinx.coroutines.CoroutineDispatcher

class CategoryDeleteUseCase(
    private val repository: CategoryRepository,
    coroutineDispatcher: CoroutineDispatcher
) : UseCase<Unit, Unit>(coroutineDispatcher) {

    override suspend fun execute(parameters: Unit) {
        TODO("Not yet implemented")
    }
}