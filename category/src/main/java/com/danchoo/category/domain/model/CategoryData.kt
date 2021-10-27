package com.danchoo.category.domain.model

sealed class CategoryData {
    data class CategoryInfoData(
        val categoryInfoModel: CategoryInfoModel = CategoryInfoModel(),
    ) : CategoryData()

    data class CategoryHeader(val title: String) : CategoryData()
}

