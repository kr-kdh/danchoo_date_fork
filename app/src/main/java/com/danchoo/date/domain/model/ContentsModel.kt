package com.danchoo.date.domain.model

sealed class ContentsModel {
    data class ContentsData(
        val contentsId: String = "",

        val title: String = "",

        val contents: String = "",

        val timestamp: Long = 0L,

        var revision: Long = 0
    ) : ContentsModel()

    data class ContentsHeader(val title: String) : ContentsModel()
}