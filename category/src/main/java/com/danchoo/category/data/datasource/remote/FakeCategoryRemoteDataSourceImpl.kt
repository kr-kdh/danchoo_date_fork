package com.danchoo.category.data.datasource.remote

import com.danchoo.retrofitutils.data.remote.BaseRemoteData

class FakeCategoryRemoteDataSourceImpl(
) : CategoryRemoteDataSource {

    override suspend fun requestCreateCategory(
        title: String,
        description: String,
        visibility: Int
    ): BaseRemoteData {
        return BaseRemoteData(true)
    }
}