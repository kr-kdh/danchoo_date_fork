package com.danchoo.date.presentation.ui.components.main.home.category

import com.danchoo.category.domain.model.CategoryModel
import com.danchoo.common.BaseIntent
import com.danchoo.common.BaseSideEffect
import com.danchoo.common.BaseViewState
import com.danchoo.components.event.ViewEvent

object CategoryContract {

    sealed class CategoryIntent : BaseIntent {
        object Idle : CategoryIntent()
    }

    sealed class CategorySideEffect : BaseSideEffect {
        object Idle : CategorySideEffect()
    }

    object CategoryViewState : BaseViewState

    sealed class CategoryViewEvent : ViewEvent {
        data class OnItemClick(
            val category: CategoryModel
        ) : CategoryViewEvent()

        object OnTitleClick : CategoryViewEvent()


        object OnAddCategory : CategoryViewEvent()
    }
}