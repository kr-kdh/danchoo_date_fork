package com.danchoo.contents.data.repository

import com.danchoo.contents.data.datasource.local.ContentsLocalDataSource
import com.danchoo.contents.data.datasource.pagingsource.ContentsPagingSource
import com.danchoo.contents.domain.model.ContentsModel
import com.danchoo.contents.domain.model.extension.toEntity
import com.danchoo.contents.domain.repository.ContentsRepository

class ContentsRepositoryImpl constructor(
    private val localDataSource: ContentsLocalDataSource,
) : ContentsRepository {
    override fun getContentsCustomPagingSource(categoryId: Long): ContentsPagingSource {
        return ContentsPagingSource(localDataSource, categoryId)
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