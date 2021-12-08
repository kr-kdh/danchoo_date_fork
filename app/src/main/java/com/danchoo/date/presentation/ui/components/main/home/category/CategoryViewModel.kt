package com.danchoo.date.presentation.ui.components.main.home.category

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.insertHeaderItem
import androidx.paging.insertSeparators
import com.danchoo.category.domain.inspector.usecase.CategoryListInsertUseCase
import com.danchoo.category.domain.inspector.usecase.CategoryPagingUseCase
import com.danchoo.category.domain.model.CategoryData
import com.danchoo.common.BaseViewModel
import com.danchoo.date.presentation.ui.components.main.home.category.CategoryContract.CategoryIntent
import com.danchoo.date.presentation.ui.components.main.home.category.CategoryContract.CategorySideEffect
import com.danchoo.date.presentation.ui.components.main.home.category.CategoryContract.CategoryViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val categoryPagingUseCase: CategoryPagingUseCase,
    private val categoryListInsertUseCase: CategoryListInsertUseCase
) : BaseViewModel<CategoryIntent, CategoryViewState, CategorySideEffect>() {
    override fun setInitialState() = CategoryViewState

    override fun handleEvents(event: CategoryIntent) {
        when (event) {
            else -> Unit
        }
    }

    private val categoryListFlow = categoryPagingUseCase().map { pagingData ->
        pagingData.insertHeaderItem(item = CategoryData.CategoryHeader("title"))
            .insertSeparators { categoryData: CategoryData?, categoryData2: CategoryData? ->
                when (categoryData) {
                    null -> CategoryData.CategoryHeader("title")
                    else -> null
                }
            }
    }.cachedIn(viewModelScope)

    fun categoryList(): Flow<PagingData<CategoryData>> {
        return categoryListFlow
    }
}