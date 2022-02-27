package com.danchoo.contents.data.datasource.local

import androidx.paging.PagingSource
import com.danchoo.contents.data.db.entity.Contents

interface ContentsLocalDataSource {
    fun getContentsList(
        timestamp: Long,
        size: Int
    ): List<Contents>

    fun getContentsList(categoryId: Long): PagingSource<Int, Contents>

    fun getTimestampByOffset(categoryId: Long, offset: Int): Long?

    fun insertContentsList(contentsList: List<Contents>)

}