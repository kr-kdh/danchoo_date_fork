package com.danchoo.date.presentation.common.tag

import com.danchoo.common.BaseEvent
import com.danchoo.common.BaseSideEffect
import com.danchoo.common.BaseViewState
import com.danchoo.components.event.ViewEvent
import com.danchoo.tags.domain.model.TagGroupModel
import com.danchoo.tags.domain.model.TagModel

object TagListContract {

    sealed class TagListEvent : BaseEvent {

    }

    data class TagListViewState(
        val keyword: String = "",
        val searchResult: List<TagModel> = emptyList(),
        val selectedList: List<TagModel> = emptyList(),
        val recentList: List<TagModel> = emptyList(),
        val tagGroupList: List<TagGroupModel> = emptyList(),
        val quickSearchResult: List<TagModel> = emptyList()
    ) : BaseViewState

    object TagListSideEffect : BaseSideEffect

    sealed class TagListViewEvent : ViewEvent {
        object OnClickBack : TagListViewEvent()
    }
}