package com.danchoo.date.presentation.ui.main.category.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.danchoo.category.domain.inspector.manager.CategoryUseCaseManager
import com.danchoo.date.presentation.ui.main.category.model.CATEGORY_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryEditViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val useCaseManager: CategoryUseCaseManager
) : ViewModel() {

    init {
        val categoryId: Long = savedStateHandle[CATEGORY_ID] ?: 0L
    }
}