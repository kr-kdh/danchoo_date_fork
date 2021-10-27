package com.danchoo.category.domain.model

import com.danchoo.tags.domain.model.TagGroupModel
import com.danchoo.tags.domain.model.TagModel

data class CategoryInfoModel(
    val category: CategoryModel = CategoryModel(),
    val tagGroupList: List<TagGroupModel> = emptyList(),
    val tagList: List<TagModel> = emptyList()
)
