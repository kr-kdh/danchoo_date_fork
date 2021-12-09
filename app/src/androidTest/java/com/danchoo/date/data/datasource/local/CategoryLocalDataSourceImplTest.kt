package com.danchoo.date.data.datasource.local

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.danchoo.category.data.datasource.local.CategoryLocalDataSource
import com.danchoo.category.data.db.entity.Category
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*
import javax.inject.Inject

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
internal class CategoryLocalDataSourceImplTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var datasource: CategoryLocalDataSource

    @Before
    fun setUp() {
        hiltRule.inject()

        for (index in 1L..10L) {
            val category = Category(
                categoryId = index,
                createTimestamp = Date().time
            )

            datasource.insert(category)
        }
    }

    @After
    fun tearDown() {
        datasource.deleteAll()
    }

    @Test
    fun getCreateTimestampByOffset() {
        /**
         * DB Index 는 1 부터 시작한다.
         */
        val category = datasource.getCategory(1)
        val createTime = datasource.getCreateTimestampByOffset(0)

        assertTrue(createTime == category?.createTimestamp)
    }

    @Test
    fun update() {
        val category = datasource.getCategory(1)
        assertNotNull(category!!)

        val updateData = category.copy(title = "updated")

        assertNotNull(updateData)

        assertEquals(category.categoryId, updateData.categoryId)

        datasource.update(updateData)

        val updatedData = datasource.getCategory(1)
        assertNotNull(updatedData!!)

        assertEquals(updatedData.categoryId, updateData.categoryId)
        assertEquals(updatedData.title, "updated")
    }


    @Test
    fun updateDefaultData() {
        val category = datasource.getCategory(1)
        assertNotNull(category!!)

        val currentTime = Date().time
        datasource.update(
            categoryId = 1,
            title = "updated",
            description = "description",
            visibility = 1,
            lastModifiedTimestamp = currentTime
        )

        val updatedData = datasource.getCategory(1)
        assertNotNull(updatedData!!)

        assertEquals(updatedData.categoryId, 1L)
        assertEquals(updatedData.title, "updated")
        assertEquals(updatedData.description, "description")
        assertEquals(updatedData.visibility, 1)
        assertEquals(updatedData.lastModifiedTimestamp, currentTime)
    }

    @Test
    fun updateSelectCount() {
        val category = datasource.getCategory(1)
        assertNotNull(category!!)

        val currentTime = Date().time
        datasource.updateReadCount(
            categoryId = 1,
            readCount = 1,
            lastReadTimestamp = currentTime
        )

        val updatedData = datasource.getCategory(1)
        assertNotNull(updatedData!!)

        assertEquals(updatedData.categoryId, 1L)
        assertEquals(updatedData.readCount, 1)
        assertEquals(updatedData.lastReadTimestamp, currentTime)
    }

    @Test
    fun delete() {
        val category = datasource.getCategory(1)
        assertNotNull(category)

        datasource.delete(1)

        val deleted = datasource.getCategory(1)
        assertNull(deleted)
    }
}