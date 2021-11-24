package com.danchoo.category.data.datasource.remote

import com.danchoo.retrofitutils.data.remote.BaseRemoteData

interface CategoryRemoteDataSource {

    suspend fun requestCreateCategory(
        title: String,
        description: String,
        visibility: Int
    ): BaseRemoteData
}