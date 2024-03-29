package com.danchoo.date.presentation.contents.editor

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.danchoo.category.domain.inspector.usecase.CategoryListUseCase
import com.danchoo.common.BaseViewModel
import com.danchoo.common.usecase.Result
import com.danchoo.date.presentation.ContentsArgsKeys
import com.danchoo.date.presentation.contents.editor.ContentsEditorContract.ContentsEditorEvent
import com.danchoo.date.presentation.contents.editor.ContentsEditorContract.ContentsEditorSideEffect
import com.danchoo.date.presentation.contents.editor.ContentsEditorContract.ContentsEditorViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContentsEditViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val categoryListUseCase: CategoryListUseCase
) : BaseViewModel<ContentsEditorEvent, ContentsEditorViewState, ContentsEditorSideEffect>() {

    init {
        val defaultCategoryId =
            savedStateHandle.get<Long>(ContentsArgsKeys.CONTENTS_CATEGORY_ID) ?: 0
        setState {
            copy(
                defaultCategoryId = defaultCategoryId,
                isCreate = savedStateHandle.get<Boolean>(ContentsArgsKeys.IS_CREATE) ?: true
            )
        }

        updateCategoryList(defaultCategoryId)
    }

    override fun setInitialState() = ContentsEditorViewState()

    override fun handleEvents(event: ContentsEditorEvent) {
        when (event) {
            is ContentsEditorEvent.ShowCategorySelectDialog -> {
                setState { copy(isShowCategorySelectDialog = true) }
            }
            is ContentsEditorEvent.HideCategorySelectDialog -> {
                setState { copy(isShowCategorySelectDialog = false) }
            }
            is ContentsEditorEvent.OnSelectCategory -> {
                setState { copy(selectedCategory = event.category) }
            }
            is ContentsEditorEvent.OnCheckedChangedVisibility -> {
                setState { copy(isVisibility = event.checked) }
            }
            is ContentsEditorEvent.OnDescriptionChanged -> {
                setState { copy(description = event.description) }
            }
        }
    }

    private fun updateCategoryList(categoryId: Long) {
        viewModelScope.launch {
            when (val result = categoryListUseCase(Unit)) {
                is Result.Success -> {
                    setState {
                        copy(
                            categoryList = result.data,
                            selectedCategory = result.data.firstOrNull { it.categoryId == categoryId }
                        )
                    }
                }
                is Result.Error -> Unit
                else -> Unit
            }
        }
    }
}