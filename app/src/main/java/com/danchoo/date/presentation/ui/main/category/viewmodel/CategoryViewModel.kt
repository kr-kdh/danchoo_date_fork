package com.danchoo.date.presentation.ui.main.category.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.danchoo.date.domain.inspactor.usecase.main.CategoryListInsertUseCase
import com.danchoo.date.domain.inspactor.usecase.main.CategoryPagingUseCase
import com.danchoo.date.domain.model.CategoryModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val categoryPagingUseCase: CategoryPagingUseCase,
    private val categoryListInsertUseCase: CategoryListInsertUseCase
) : ViewModel() {

    private val _categoryList = MutableLiveData<PagingData<CategoryModel>>()
    val categoryList: LiveData<PagingData<CategoryModel>>
        get() {
            return _categoryList
        }

    suspend fun bindCategoryList() {
        categoryPagingUseCase()
            .cachedIn(viewModelScope)
            .collect {
                _categoryList.value = it
            }
    }

    fun categoryList(): Flow<PagingData<CategoryModel>> {
        return categoryPagingUseCase()
            .cachedIn(viewModelScope).apply {
                viewModelScope.launch {
                    collect { pagingData ->

                        Log.d("_SMY", "categoryList $pagingData")
                    }
                }
            }
    }

    fun addCategory() {
        viewModelScope.launch {
            Log.d("_SMY", "addCategory")
            categoryListInsertUseCase(Unit)
        }
    }
}