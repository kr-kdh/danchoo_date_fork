package com.danchoo.date.domain.model

sealed class CategoryModel {
    data class CategoryData(
        val categoryId: String = "",

        val title: String = "",

        val contents: String = "",

        val timestamp: Long = 0L,

        var revision: Long = 0
    ) : CategoryModel()

    data class CategoryHeader(val title: String) : CategoryModel()
}

