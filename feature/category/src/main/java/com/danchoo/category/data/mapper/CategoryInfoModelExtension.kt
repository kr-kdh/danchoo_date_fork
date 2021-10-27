package com.danchoo.category.data.mapper

import com.danchoo.category.data.db.entity.CategoryInfo
import com.danchoo.category.domain.model.CategoryInfoModel
import com.danchoo.date.domain.model.extension.toEntity
import com.danchoo.date.domain.model.extension.toModel
import com.danchoo.tags.data.mapper.toEntity
import com.danchoo.tags.data.mapper.toModel


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