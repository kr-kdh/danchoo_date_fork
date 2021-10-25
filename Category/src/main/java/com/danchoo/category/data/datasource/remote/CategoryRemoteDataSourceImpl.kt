package com.danchoo.category.data.datasource.remote

import com.danchoo.category.data.remote.api.CategoryApiInterface
import com.danchoo.common.data.remote.BaseRemoteData

class CategoryRemoteDataSourceImpl(
    private val apiInterface: CategoryApiInterface
) : CategoryRemoteDataSource {

    override suspend fun requestCreateCategory(
        title: String,
        description: String,
        visibility: Int
    ): BaseRemoteData {
        return apiInterface.requestCategoryList()
    }
}