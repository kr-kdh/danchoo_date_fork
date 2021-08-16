package com.danchoo.date.domain.model

data class CategoryModel(
    val hash: String = "",

    val title: String = "",

    val contents: String = "",

    val timestamp: Long = 0L,

    var revision : Long = 0
) {
}