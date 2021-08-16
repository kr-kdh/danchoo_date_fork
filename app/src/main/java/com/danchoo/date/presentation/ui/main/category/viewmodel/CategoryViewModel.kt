package com.danchoo.date.presentation.ui.main.category.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.danchoo.date.domain.inspactor.usecase.main.CategoryListInsertUseCase
import com.danchoo.date.domain.inspactor.usecase.main.CategoryPagingUseCase
import com.danchoo.date.domain.model.CategoryModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
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

    fun categoryList(): Flow<PagingData<CategoryModel>> {
        return categoryPagingUseCase().cachedIn(viewModelScope)
    }

    fun addCategory() {
        viewModelScope.launch {
            Log.d("_SMY", "addCategory")
            categoryListInsertUseCase(Unit)
        }
    }
}