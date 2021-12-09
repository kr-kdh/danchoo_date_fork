package com.danchoo.date.presentation.ui.components.main.editor.category

import com.danchoo.common.BaseViewModel
import com.danchoo.date.presentation.ui.components.main.editor.category.CategoryEditorContract.CategoryEditorIntent
import com.danchoo.date.presentation.ui.components.main.editor.category.CategoryEditorContract.CategoryEditorSideEffect
import com.danchoo.date.presentation.ui.components.main.editor.category.CategoryEditorContract.CategoryEditorViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryEditorViewModel @Inject constructor(

) : BaseViewModel<CategoryEditorIntent, CategoryEditorViewState, CategoryEditorSideEffect>() {
    override fun setInitialState() = CategoryEditorViewState()

    override fun handleEvents(event: CategoryEditorIntent) {

    }
}