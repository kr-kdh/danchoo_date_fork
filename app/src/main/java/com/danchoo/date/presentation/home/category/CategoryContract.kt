package com.danchoo.date.presentation.home.category

import com.danchoo.category.domain.model.CategoryModel
import com.danchoo.common.BaseEvent
import com.danchoo.common.BaseSideEffect
import com.danchoo.common.BaseViewState
import com.danchoo.components.event.ViewEvent

object CategoryContract {

    sealed class CategoryEvent : BaseEvent {
        object Idle : CategoryEvent()
    }

    sealed class CategorySideEffect : BaseSideEffect {
        object Idle : CategorySideEffect()
    }

    object CategoryViewState : BaseViewState

    sealed class CategoryViewEvent : ViewEvent {
        data class OnItemClick(
            val category: CategoryModel
        ) : CategoryViewEvent()


        object OnAddCategory : CategoryViewEvent()
    }
}