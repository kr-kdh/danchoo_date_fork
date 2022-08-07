package com.danchoo.date.presentation.contents

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.danchoo.common.BaseViewModel
import com.danchoo.contents.domain.inspector.usecase.ContentsListInsertUseCase
import com.danchoo.contents.domain.inspector.usecase.ContentsPagingUseCase
import com.danchoo.contents.domain.model.ContentsModel
import com.danchoo.date.presentation.ContentsArgsKeys
import com.danchoo.date.presentation.contents.ContentsContract.ContentsEvent
import com.danchoo.date.presentation.contents.ContentsContract.ContentsSideEffect
import com.danchoo.date.presentation.contents.ContentsContract.ContentsViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContentsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val contentsPagingUseCase: ContentsPagingUseCase,
    private val contentsListInsertUseCase: ContentsListInsertUseCase
) : BaseViewModel<ContentsEvent, ContentsViewState, ContentsSideEffect>() {

    init {
        setState {
            copy(
                categoryId = savedStateHandle.get<Long>(ContentsArgsKeys.CONTENTS_CATEGORY_ID) ?: 0
            )
        }
    }

    override fun setInitialState() = ContentsViewState()

    override fun handleEvents(event: ContentsEvent) {
    }

    fun contentsList(): Flow<PagingData<ContentsModel>> {
        return contentsPagingUseCase(viewState.value.categoryId)
            .cachedIn(viewModelScope)
            .distinctUntilChanged()
    }

    fun addContents() {
        viewModelScope.launch {
            contentsListInsertUseCase(Unit)
        }
    }
}