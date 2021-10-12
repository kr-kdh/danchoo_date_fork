package com.danchoo.date.data.datasource.remote

import com.danchoo.date.data.remote.BaseRemoteData

interface CategoryRemoteDataSource {

    fun requestCreateCategory(
        title: String,
        description: String,
        visibility: Int
    ): BaseRemoteData
}