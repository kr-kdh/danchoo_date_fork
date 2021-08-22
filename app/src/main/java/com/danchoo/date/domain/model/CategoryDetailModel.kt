package com.danchoo.date.domain.model

sealed class CategoryDetailModel {
    data class CategoryDetailData(
        val hash: String = "",

        val title: String = "",

        val contents: String = "",

        val timestamp: Long = 0L,

        var revision: Long = 0
    ) : CategoryDetailModel()

    data class CategoryHeader(val title: String) : CategoryDetailModel()
}