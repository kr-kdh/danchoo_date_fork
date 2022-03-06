package com.danchoo.date.presentation.contents.editor

import com.danchoo.category.domain.model.CategoryModel
import com.danchoo.common.BaseIntent
import com.danchoo.common.BaseSideEffect
import com.danchoo.common.BaseViewState
import com.danchoo.components.event.ViewEvent
import com.danchoo.contents.domain.model.ContentsMediaModel

object ContentsEditorContract {

    sealed class ContentsEditorIntent : BaseIntent {
        object ShowCategorySelectDialog : ContentsEditorIntent()
        object HideCategorySelectDialog : ContentsEditorIntent()
        data class OnSelectCategory(val category: CategoryModel) : ContentsEditorIntent()
        data class OnCheckedChangedVisibility(val checked: Boolean) : ContentsEditorIntent()
    }

    data class ContentsEditorViewState(
        val isCreate: Boolean = true,
        val defaultCategoryId: Long = 0,
        val selectedCategory: CategoryModel? = null,
        val isEnableConfirm: Boolean = false,
        val mediaList: List<ContentsMediaModel> = emptyList(),
        val isShowCategorySelectDialog: Boolean = false,
        val categoryList: List<CategoryModel> = emptyList(),
        val isVisibility: Boolean = false
    ) : BaseViewState

    object ContentsEditorSideEffect : BaseSideEffect

    sealed class ContentsEditorViewEvent : ViewEvent {
        object OnClickBack : ContentsEditorViewEvent()
        object OnClickConfirm : ContentsEditorViewEvent()
        object OnClickCategoryList : ContentsEditorViewEvent()

        data class OnCheckedChangedVisibility(val checked: Boolean) : ContentsEditorViewEvent()

        data class OnClickDeleteMedia(
            val mediaModel: ContentsMediaModel
        ) : ContentsEditorViewEvent()
    }
}