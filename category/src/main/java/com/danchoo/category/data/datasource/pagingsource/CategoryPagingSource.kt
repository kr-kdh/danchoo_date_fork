package com.danchoo.category.data.datasource.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.danchoo.category.data.datasource.local.CategoryLocalDataSource
import com.danchoo.category.data.mapper.toModel
import com.danchoo.category.domain.model.CategoryData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryPagingSource constructor(
    private val localDataSource: CategoryLocalDataSource
) : PagingSource<Int, CategoryData>() {

    override fun getRefreshKey(state: PagingState<Int, CategoryData>): Int? {
        // Try to find the page key of the closest page to anchorPosition, from
        // either the prevKey or the nextKey, but you need to handle nullability
        // here:
        //  * prevKey == null -> anchorPage is the first page.
        //  * nextKey == null -> anchorPage is the last page.
        //  * both prevKey and nextKey null -> anchorPage is the initial page, so
        //    just return null.
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CategoryData> {
        return withContext(Dispatchers.IO) {
            val key = params.key ?: 0
            val categoryList = getCategoryList(key, params.loadSize)

            val prevKey = if (key == 0) null else key - 1
            val nextKey = if (categoryList.isNullOrEmpty()) null else key + 1

            try {
                LoadResult.Page(
                    data = categoryList,
                    prevKey = prevKey,
                    nextKey = nextKey
                )
            } catch (e: Exception) {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = prevKey,
                    nextKey = nextKey
                )
            }
        }
    }

    private fun getCategoryList(key: Int, loadSize: Int): List<CategoryData> {
        val offset = key * loadSize

        val timestamp = localDataSource.getCreateTimestampByOffset(offset) ?: -1
        if (timestamp == -1L) {
            return emptyList()
        }

        return localDataSource.getCategoryInfoList(
            timestamp = timestamp,
            size = loadSize
        ).map {
            CategoryData.CategoryInfoData(it.toModel())
        }
    }
}