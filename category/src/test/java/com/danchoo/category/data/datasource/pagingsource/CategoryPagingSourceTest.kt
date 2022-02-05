package com.danchoo.category.data.datasource.pagingsource

import androidx.paging.PagingSource
import com.danchoo.category.data.datasource.local.CategoryLocalDataSource
import com.danchoo.category.data.db.entity.Category
import com.danchoo.category.data.db.entity.CategoryInfo
import com.danchoo.category.data.mapper.toModel
import com.danchoo.category.domain.model.CategoryData
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito

internal class CategoryPagingSourceTest {

    private lateinit var mockDataSource: CategoryLocalDataSource// = Mockito.mock(CategoryLocalDataSource::class.java)


    @BeforeEach
    fun setUp() {
        mockDataSource = Mockito.mock(CategoryLocalDataSource::class.java)
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun loadReturnsPageWhenOnSuccessfulLoadOfItemKeyedData() = runTest {
        val pagingSource = CategoryPagingSource(mockDataSource)

        val key = 0
        val loadSize = 2
        val offset = key * loadSize
        val timestamp = 0L
        val resultList = listOf<CategoryInfo>(
            CategoryInfo(category = Category(0)),
            CategoryInfo(category = Category(1))
        )

        Mockito.`when`(mockDataSource.getCreateTimestampByOffset(offset)).thenReturn(timestamp)
        Mockito.`when`(mockDataSource.getCategoryInfoList(timestamp, loadSize))
            .thenReturn(resultList)

        val page = PagingSource.LoadResult.Page(
            data = resultList.map { CategoryData.CategoryInfoData(it.toModel()) },
            prevKey = null,
            nextKey = key + 1
        )

        val loadResult = pagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = key,
                loadSize = loadSize,
                placeholdersEnabled = false
            )
        ) as PagingSource.LoadResult.Page


        assert(page == loadResult)
    }


}
