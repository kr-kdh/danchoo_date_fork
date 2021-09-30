package com.danchoo.date.presentation.ui.main.category.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.insertHeaderItem
import androidx.paging.insertSeparators
import com.danchoo.date.domain.inspactor.usecase.main.category.CategoryListInsertUseCase
import com.danchoo.date.domain.inspactor.usecase.main.category.CategoryPagingUseCase
import com.danchoo.date.domain.model.CategoryData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val categoryPagingUseCase: CategoryPagingUseCase,
    private val categoryListInsertUseCase: CategoryListInsertUseCase
) : ViewModel() {

    @ExperimentalCoroutinesApi
    fun categoryList(): Flow<PagingData<CategoryData>> {
        return categoryPagingUseCase().map { pagingData ->
            pagingData.insertHeaderItem(item = CategoryData.CategoryHeader("title"))
                .insertSeparators { categoryData: CategoryData?, categoryData2: CategoryData? ->
                    when (categoryData) {
                        null -> CategoryData.CategoryHeader("title")
                        else -> null
                    }
                }
        }.cachedIn(viewModelScope)
    }
}