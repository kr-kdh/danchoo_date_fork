package com.danchoo.category.domain.inspector.manager.impl

import com.danchoo.category.domain.inspector.manager.CategoryUseCaseManager
import com.danchoo.category.domain.inspector.usecase.CategoryCreateUseCase
import com.danchoo.category.domain.inspector.usecase.CategoryCreateUseCase.CategoryCreateParameter
import com.danchoo.category.domain.model.CategoryModel
import com.danchoo.inspactor.usecase.Result

class CategoryUseCaseManagerImpl(
    private val categoryCreateUseCase: CategoryCreateUseCase
) : CategoryUseCaseManager {

    suspend fun create(
        title: String,
        description: String = "",
        visibility: Int = 0,
        currentTimestamp: Long
    ): Result<CategoryModel> {
        return categoryCreateUseCase(
            CategoryCreateParameter(
                title = title,
                description = description,
                visibility = visibility,
                currentTimestamp = currentTimestamp
            )
        )
    }
}