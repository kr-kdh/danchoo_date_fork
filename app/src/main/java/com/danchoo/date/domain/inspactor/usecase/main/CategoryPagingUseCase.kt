package com.danchoo.date.domain.inspactor.usecase.main

import androidx.paging.*
import com.danchoo.date.data.db.entity.extension.toModel
import com.danchoo.date.domain.model.CategoryModel
import com.danchoo.date.domain.repository.CategoryRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class CategoryPagingUseCase @Inject constructor(
    val repository: CategoryRepository
) {
    private val sourceModel = CategoryModel.CategoryData()

    @ExperimentalCoroutinesApi
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

//    {
//        repository.getCategoryPagingSource()
//    }.flow
//        .distinctUntilChanged()
//        .mapLatest { pagingData ->
//            pagingData.map { it.toModel(sourceModel) }
//                .insertHeaderItem(item = CategoryModel.CategoryHeader("title"))
//                .insertSeparators { categoryModel: CategoryModel?, categoryModel2: CategoryModel? ->
//                    when (categoryModel) {
//                        null -> CategoryModel.CategoryHeader("title")
//                        else -> null
//                    }
//                }
//        }

}