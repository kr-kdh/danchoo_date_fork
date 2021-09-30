package com.danchoo.date.domain.inspactor.usecase.main.category

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.danchoo.date.domain.model.CategoryData
import com.danchoo.date.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoryPagingUseCase @Inject constructor(
    val repository: CategoryRepository
) {
    operator fun invoke(): Flow<PagingData<CategoryData>> = Pager(
        config = PagingConfig(
            pageSize = 10,
            prefetchDistance = 10,
            enablePlaceholders = false,
            maxSize = Int.MAX_VALUE
        )
    ) {
        repository.getCategoryCustomPagingSource()
    }.flow

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