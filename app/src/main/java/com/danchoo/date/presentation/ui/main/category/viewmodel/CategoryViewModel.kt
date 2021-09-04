package com.danchoo.date.presentation.ui.main.category.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.insertHeaderItem
import androidx.paging.insertSeparators
import com.danchoo.date.domain.inspactor.usecase.main.category.CategoryListInsertUseCase
import com.danchoo.date.domain.inspactor.usecase.main.category.CategoryPagingUseCase
import com.danchoo.date.domain.model.CategoryModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val categoryPagingUseCase: CategoryPagingUseCase,
    private val categoryListInsertUseCase: CategoryListInsertUseCase
) : ViewModel() {

    @ExperimentalCoroutinesApi
    fun categoryList(): Flow<PagingData<CategoryModel>> {
        return categoryPagingUseCase().map { pagingData ->
            pagingData.insertHeaderItem(item = CategoryModel.CategoryHeader("title"))
                .insertSeparators { categoryModel: CategoryModel?, categoryModel2: CategoryModel? ->
                    when (categoryModel) {
                        null -> CategoryModel.CategoryHeader("title")
                        else -> null
                    }
                }
        }.cachedIn(viewModelScope)
    }

    fun addCategory() {
        viewModelScope.launch {
            Log.d("_SMY", "addCategory")
            categoryListInsertUseCase(Unit)
        }
    }
}