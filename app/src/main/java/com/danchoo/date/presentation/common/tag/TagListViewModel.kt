package com.danchoo.date.presentation.common.tag

import com.danchoo.common.BaseViewModel
import com.danchoo.date.presentation.common.tag.TagListContract.TagListEvent
import com.danchoo.date.presentation.common.tag.TagListContract.TagListSideEffect
import com.danchoo.date.presentation.common.tag.TagListContract.TagListViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TagListViewModel @Inject constructor(

) : BaseViewModel<TagListEvent, TagListViewState, TagListSideEffect>() {
    override fun setInitialState() = TagListViewState()

    override fun handleEvents(event: TagListEvent) {
        when (event) {
        }
    }
}