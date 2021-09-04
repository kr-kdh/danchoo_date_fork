package com.danchoo.date.domain.repository

import androidx.paging.PagingSource
import com.danchoo.date.data.db.entity.Contents
import com.danchoo.date.data.pagingsource.ContentsPagingSource
import com.danchoo.date.domain.model.ContentsModel

interface ContentsRepository {

    fun getCategoryPagingSource(): PagingSource<Int, Contents>

    fun getContentsCustomPagingSource(): ContentsPagingSource

    fun insertCategory(categoryList: List<ContentsModel>)

}