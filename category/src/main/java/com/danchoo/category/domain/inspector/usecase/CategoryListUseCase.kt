package com.danchoo.category.domain.inspector.usecase

import com.danchoo.category.domain.model.CategoryModel
import com.danchoo.category.domain.repository.CategoryRepository
import com.danchoo.common.usecase.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class CategoryListUseCase @Inject constructor(
    private val repository: CategoryRepository,
    dispatcher: CoroutineDispatcher
) : UseCase<Unit, List<CategoryModel>>(dispatcher) {
    override suspend fun execute(parameters: Unit): List<CategoryModel> {
        return repository.getCategoryList()
    }
}