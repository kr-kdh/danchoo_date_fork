package com.danchoo.date.data.datasource.local

import androidx.paging.PagingSource
import com.danchoo.date.data.db.dao.ContentsDao
import com.danchoo.date.data.db.entity.Contents

class ContentsLocalDataSourceImpl internal constructor(
    private val contentsDao: ContentsDao
) : ContentsLocalDataSource {
    override fun getContentsList(timestamp: Long, size: Int): List<Contents> {
        return contentsDao.getContentsList(timestamp, size)
    }

    override fun getContentsList(): PagingSource<Int, Contents> {
        return contentsDao.getContentsList()
    }

    override fun getTimestampByOffset(offset: Int): Long? {
        return contentsDao.getTimestampByOffset(offset)
    }

    override fun insertContentsList(contentsList: List<Contents>) {
        return contentsDao.insertAll(contentsList)
    }
}