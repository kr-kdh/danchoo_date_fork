package com.danchoo.date.presentation.ui.main.contents

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.insertHeaderItem
import androidx.paging.insertSeparators
import com.danchoo.date.domain.inspactor.usecase.main.contents.ContentsPagingUseCase
import com.danchoo.date.domain.model.ContentsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ContentsViewModel @Inject constructor(
    val contentsPagingUseCase: ContentsPagingUseCase
) : ViewModel() {

    @ExperimentalCoroutinesApi
    fun contentsList(): Flow<PagingData<ContentsModel>> {
        return contentsPagingUseCase().map { pagingData ->
            pagingData.insertHeaderItem(item = ContentsModel.ContentsHeader("title"))
                .insertSeparators { contentsModel: ContentsModel?, contentsModel2: ContentsModel? ->
                    when (contentsModel) {
                        null -> ContentsModel.ContentsHeader("title")
                        else -> null
                    }
                }
        }.cachedIn(viewModelScope)
    }
}