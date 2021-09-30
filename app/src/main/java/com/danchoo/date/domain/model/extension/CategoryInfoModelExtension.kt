package com.danchoo.date.domain.model.extension

import com.danchoo.date.data.db.entity.CategoryInfo
import com.danchoo.date.domain.model.CategoryInfoModel


fun CategoryInfo.toModel(): CategoryInfoModel {
    return CategoryInfoModel(
        category = category.toModel(),
        tagGroupList = tagGroupList.map { it.toModel() },
        tagList = tagList.map { it.toModel() }
    )
}

fun CategoryInfoModel.toEntity(): CategoryInfo {
    return CategoryInfo(
        category = category.toEntity(),
        tagGroupList = tagGroupList.map { it.toEntity() },
        tagList = tagList.map { it.toEntity() }
    )
}