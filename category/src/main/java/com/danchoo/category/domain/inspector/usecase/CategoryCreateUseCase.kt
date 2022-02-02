package com.danchoo.category.domain.inspector.usecase

import android.net.Uri
import com.danchoo.category.domain.inspector.usecase.CategoryCreateUseCase.CategoryCreateParameter
import com.danchoo.category.domain.model.CategoryModel
import com.danchoo.category.domain.repository.CategoryRepository
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
            visibility = parameters.visibility,
            coverImageUri = parameters.coverImageUri,
            currentTimestamp = parameters.currentTimestamp
        ) ?: throw Exception()

        return category
    }

    data class CategoryCreateParameter(
        val title: String,
        val description: String = "",
        val visibility: Int = 0,
        val coverImageUri: Uri,
        val currentTimestamp: Long
    )
}