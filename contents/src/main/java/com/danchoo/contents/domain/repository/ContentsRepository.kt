package com.danchoo.contents.domain.repository

import com.danchoo.contents.data.datasource.pagingsource.ContentsPagingSource
import com.danchoo.contents.domain.model.ContentsModel

interface ContentsRepository {

    fun getContentsCustomPagingSource(categoryId: Long): ContentsPagingSource

    fun insertContents(categoryList: List<ContentsModel>)

}