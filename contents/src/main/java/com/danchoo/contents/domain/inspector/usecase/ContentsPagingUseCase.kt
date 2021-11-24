package com.danchoo.contents.domain.inspector.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.danchoo.contents.domain.model.ContentsModel
import com.danchoo.contents.domain.repository.ContentsRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ContentsPagingUseCase @Inject constructor(
    val repository: ContentsRepository
) {

    @ExperimentalCoroutinesApi
    operator fun invoke(): Flow<PagingData<ContentsModel>> = Pager(
        config = PagingConfig(
            pageSize = 10,
            prefetchDistance = 10,
            enablePlaceholders = false,
            maxSize = Int.MAX_VALUE
        )
    ) {
        repository.getContentsCustomPagingSource()
    }.flow
}