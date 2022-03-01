package com.danchoo.date.presentation.contents.editor

import androidx.lifecycle.SavedStateHandle
import com.danchoo.common.BaseViewModel
import com.danchoo.date.presentation.ContentsArgsKeys
import com.danchoo.date.presentation.contents.editor.ContentsEditorContract.ContentsEditorIntent
import com.danchoo.date.presentation.contents.editor.ContentsEditorContract.ContentsEditorSideEffect
import com.danchoo.date.presentation.contents.editor.ContentsEditorContract.ContentsEditorViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContentsEditViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : BaseViewModel<ContentsEditorIntent, ContentsEditorViewState, ContentsEditorSideEffect>() {

    init {
        setState {
            copy(
                categoryId = savedStateHandle.get<Long>(ContentsArgsKeys.CONTENTS_CATEGORY_ID) ?: 0,
                isCreate = savedStateHandle.get<Boolean>(ContentsArgsKeys.IS_CREATE) ?: true
            )
        }
    }

    override fun setInitialState() = ContentsEditorViewState()

    override fun handleEvents(event: ContentsEditorIntent) {
    }
}