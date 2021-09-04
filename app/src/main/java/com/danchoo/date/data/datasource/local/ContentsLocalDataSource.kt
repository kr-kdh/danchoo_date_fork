package com.danchoo.date.data.datasource.local

import androidx.paging.PagingSource
import com.danchoo.date.data.db.entity.Contents

interface ContentsLocalDataSource {
    fun getContentsList(
        timestamp: Long,
        size: Int
    ): List<Contents>

    fun getContentsList(): PagingSource<Int, Contents>

    fun getTimestampByOffset(offset: Int): Long?

    fun insertContentsList(categoryList: List<Contents>)

}