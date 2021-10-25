package com.danchoo.category.data.datasource.remote

import com.danchoo.common.data.remote.BaseRemoteData

interface CategoryRemoteDataSource {

    suspend fun requestCreateCategory(
        title: String,
        description: String,
        visibility: Int
    ): BaseRemoteData
}