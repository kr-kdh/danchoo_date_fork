package com.danchoo.date.domain.inspactor.usecase.main

import androidx.paging.InvalidatingPagingSourceFactory
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.danchoo.date.domain.inspactor.usecase.base.UseCase
import com.danchoo.date.domain.model.CategoryModel
import com.danchoo.date.domain.repository.CategoryRepository
import kotlinx.coroutines.CoroutineDispatcher
import java.util.*
import javax.inject.Inject

class CategoryPagingUseCase @Inject constructor(
    repository: CategoryRepository
) {

    private val pagingSource = repository.getCategoryPagingSource()

    operator fun invoke() = Pager(
        config = PagingConfig(
            pageSize = 10,
            prefetchDistance = 10,
            enablePlaceholders = false,
            maxSize = Int.MAX_VALUE
        ),
        pagingSourceFactory = {pagingSource}
    ).flow
}