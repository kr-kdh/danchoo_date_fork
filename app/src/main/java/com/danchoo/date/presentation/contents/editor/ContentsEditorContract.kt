package com.danchoo.date.presentation.contents.editor

import com.danchoo.category.domain.model.CategoryModel
import com.danchoo.common.BaseEvent
import com.danchoo.common.BaseSideEffect
import com.danchoo.common.BaseViewState
import com.danchoo.components.event.ViewEvent
import com.danchoo.contents.domain.model.ContentsMediaModel
import com.danchoo.tags.domain.model.TagModel

object ContentsEditorContract {

    sealed class ContentsEditorEvent : BaseEvent {
        object ShowCategorySelectDialog : ContentsEditorEvent()
        object HideCategorySelectDialog : ContentsEditorEvent()
        data class OnSelectCategory(val category: CategoryModel) : ContentsEditorEvent()
        data class OnCheckedChangedVisibility(val checked: Boolean) : ContentsEditorEvent()
        data class OnDescriptionChanged(val description: String) : ContentsEditorEvent()
    }

    data class ContentsEditorViewState(
        val isCreate: Boolean = true,
        val defaultCategoryId: Long = 0,
        val selectedCategory: CategoryModel? = null,
        val isEnableConfirm: Boolean = false,
        val mediaList: List<ContentsMediaModel> = emptyList(),
        val isShowCategorySelectDialog: Boolean = false,
        val categoryList: List<CategoryModel> = emptyList(),
        val isVisibility: Boolean = false,
        val description: String = "",
        val tagList: List<TagModel> = emptyList()
    ) : BaseViewState

    object ContentsEditorSideEffect : BaseSideEffect

    sealed class ContentsEditorViewEvent : ViewEvent {
        object OnClickBack : ContentsEditorViewEvent()
        object OnClickConfirm : ContentsEditorViewEvent()
        object OnClickCategoryList : ContentsEditorViewEvent()
        object OnClickAddTag : ContentsEditorViewEvent()
        data class OnClickDeleteTag(val tagModel: TagModel) : ContentsEditorViewEvent()

        data class OnCheckedChangedVisibility(val checked: Boolean) : ContentsEditorViewEvent()

        data class OnDescriptionChanged(val description: String) : ContentsEditorViewEvent()

        data class OnClickDeleteMedia(
            val mediaModel: ContentsMediaModel
        ) : ContentsEditorViewEvent()
    }
}