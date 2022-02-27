package com.danchoo.contents.data.datasource.local

import androidx.paging.PagingSource
import com.danchoo.contents.data.db.dao.ContentsDao
import com.danchoo.contents.data.db.entity.Contents

class ContentsLocalDataSourceImpl constructor(
    private val contentsDao: ContentsDao
) : ContentsLocalDataSource {
    override fun getContentsList(timestamp: Long, size: Int): List<Contents> {
        return contentsDao.getContentsList(timestamp, size)
    }

    override fun getContentsList(categoryId: Long): PagingSource<Int, Contents> {
        return contentsDao.getContentsList(categoryId)
    }

    override fun getTimestampByOffset(categoryId: Long, offset: Int): Long? {
        return contentsDao.getTimestampByOffset(categoryId, offset)
    }

    override fun insertContentsList(contentsList: List<Contents>) {
        return contentsDao.insertAll(contentsList)
    }
}