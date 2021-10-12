package com.danchoo.date.data.datasource.remote

import com.danchoo.date.data.remote.BaseRemoteData

class CategoryRemoteDataSourceImpl : CategoryRemoteDataSource {
    override fun requestCreateCategory(
        title: String,
        description: String,
        visibility: Int
    ): BaseRemoteData {
        TODO("Not yet implemented")
    }
}