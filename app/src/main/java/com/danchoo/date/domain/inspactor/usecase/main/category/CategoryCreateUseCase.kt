package com.danchoo.date.domain.inspactor.usecase.main.category

import com.danchoo.date.domain.inspactor.usecase.main.category.CategoryCreateUseCase.CategoryCreateParameter
import com.danchoo.date.domain.model.CategoryModel
import com.danchoo.date.domain.model.constants.Visibility
import com.danchoo.date.domain.repository.CategoryRepository
import com.danchoo.inspactor.usecase.UseCase
import kotlinx.coroutines.CoroutineDispatcher

class CategoryCreateUseCase(
    private val repository: CategoryRepository,
    coroutineDispatcher: CoroutineDispatcher
) : UseCase<CategoryCreateParameter, CategoryModel>(coroutineDispatcher) {

    override suspend fun execute(parameters: CategoryCreateParameter): CategoryModel {
        val category = repository.createCategory(
            title = parameters.title,
            description = parameters.description,
            visibility = parameters.visibility
        ) ?: throw Exception()

        return category
    }

    data class CategoryCreateParameter(
        val title: String,
        val description: String = "",
        val visibility: Visibility = Visibility.Visible,
        val currentTimestamp: Long
    )
}