package com.danchoo.date.domain.model

data class CategoryInfoModel(
    val category: CategoryModel = CategoryModel(),
    val tagGroupList: List<TagGroupModel> = emptyList(),
    val tagList: List<TagModel> = emptyList()
)
