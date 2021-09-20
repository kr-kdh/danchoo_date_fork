package com.danchoo.date.domain.repository

import com.danchoo.date.data.pagingsource.ContentsPagingSource
import com.danchoo.date.domain.model.ContentsModel

interface ContentsRepository {

    fun getContentsCustomPagingSource(): ContentsPagingSource

    fun insertContents(categoryList: List<ContentsModel>)

}