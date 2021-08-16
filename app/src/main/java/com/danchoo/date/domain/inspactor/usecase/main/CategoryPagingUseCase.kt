package com.danchoo.date.domain.inspactor.usecase.main

import androidx.paging.*
import com.danchoo.date.domain.model.CategoryModel
import com.danchoo.date.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CategoryPagingUseCase @Inject constructor(
    val repository: CategoryRepository
) {
    operator fun invoke(): Flow<PagingData<CategoryModel>> = Pager(
        config = PagingConfig(
            pageSize = 10,
            prefetchDistance = 10,
            enablePlaceholders = false,
            maxSize = Int.MAX_VALUE
        )
    ) {
        repository.getCategoryCustomPagingSource()
    }.flow
        .map { pagingData ->
            pagingData.insertHeaderItem(item = CategoryModel.CategoryHeader("title"))
                .insertSeparators { categoryModel: CategoryModel?, categoryModel2: CategoryModel? ->
                    when (categoryModel) {
                        null -> CategoryModel.CategoryHeader("title")
                        else -> null
                    }
                }
        }

}