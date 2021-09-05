package com.danchoo.date.data.repository

import androidx.paging.PagingSource
import com.danchoo.date.data.datasource.local.ContentsLocalDataSource
import com.danchoo.date.data.db.entity.Contents
import com.danchoo.date.data.pagingsource.ContentsPagingSource
import com.danchoo.date.domain.model.ContentsModel
import com.danchoo.date.domain.model.extension.toEntity
import com.danchoo.date.domain.repository.ContentsRepository

class ContentsRepositoryImpl constructor(
    private val localDataSource: ContentsLocalDataSource,
) : ContentsRepository {
    override fun getCategoryPagingSource(): PagingSource<Int, Contents> {
        return localDataSource.getContentsList()
    }

    override fun getContentsCustomPagingSource(): ContentsPagingSource {
        return ContentsPagingSource(localDataSource)
    }

    override fun insertContents(categoryList: List<ContentsModel>) {
        val list = categoryList
            .asSequence()
            .filter { it is ContentsModel.ContentsData }
            .map {
                (it as ContentsModel.ContentsData).toEntity()
            }.toList()

        localDataSource.insertContentsList(list)
    }

}