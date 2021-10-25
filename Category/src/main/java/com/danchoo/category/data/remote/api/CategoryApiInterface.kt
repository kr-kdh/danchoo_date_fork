package com.danchoo.category.data.remote.api

import com.danchoo.category.data.remote.RestConstants
import com.danchoo.common.data.remote.BaseRemoteData
import retrofit2.http.POST

interface CategoryApiInterface {

    @POST("${RestConstants.API_CATEGORY_V1}/list/")
    suspend fun requestCategoryList(): BaseRemoteData

}