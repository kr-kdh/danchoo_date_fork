package com.danchoo.date.presentation.contents

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.danchoo.contents.domain.inspector.usecase.ContentsListInsertUseCase
import com.danchoo.contents.domain.inspector.usecase.ContentsPagingUseCase
import com.danchoo.contents.domain.model.ContentsModel
import com.danchoo.date.presentation.ContentsArgsKeys
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
) : ViewModel() {

    private val categoryId = savedStateHandle.get<Long>(ContentsArgsKeys.CONTENTS_CATEGORY_ID) ?: 0

    fun contentsList(): Flow<PagingData<ContentsModel>> {
        return contentsPagingUseCase(categoryId)
            .cachedIn(viewModelScope)
            .distinctUntilChanged()
    }

    fun addContents() {
        viewModelScope.launch {
            contentsListInsertUseCase(Unit)
        }
    }
}