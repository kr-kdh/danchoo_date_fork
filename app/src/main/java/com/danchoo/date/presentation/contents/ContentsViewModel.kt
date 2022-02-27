package com.danchoo.date.presentation.contents

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.insertHeaderItem
import androidx.paging.insertSeparators
import com.danchoo.contents.domain.inspector.usecase.ContentsListInsertUseCase
import com.danchoo.contents.domain.inspector.usecase.ContentsPagingUseCase
import com.danchoo.contents.domain.model.ContentsModel
import com.danchoo.date.presentation.ContentsArgsKeys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContentsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val contentsPagingUseCase: ContentsPagingUseCase,
    private val contentsListInsertUseCase: ContentsListInsertUseCase
) : ViewModel() {

    init {
        val categoryId = savedStateHandle.get<Long>(ContentsArgsKeys.CONTENTS_CATEGORY_ID)
    }

    fun contentsList(): Flow<PagingData<ContentsModel>> {
        return contentsPagingUseCase()
            .mapLatest { pagingData ->
                pagingData.insertHeaderItem(item = ContentsModel.ContentsHeader("title"))
                    .insertSeparators { contentsModel: ContentsModel?, contentsModel2: ContentsModel? ->
                        when (contentsModel) {
                            null -> ContentsModel.ContentsHeader("title")
                            else -> null
                        }
                    }
            }
            .cachedIn(viewModelScope)
            .distinctUntilChanged()
    }

    fun addContents() {
        viewModelScope.launch {
            contentsListInsertUseCase(Unit)
        }
    }
}