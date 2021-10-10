package com.danchoo.date.data.datasource.local

import androidx.test.runner.AndroidJUnit4
import com.danchoo.date.data.db.entity.Category
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Assert.assertTrue
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

        for (index in 0L..10L) {
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
        val category = datasource.getCategory(1)
        val createTime = datasource.getCreateTimestampByOffset(0)

        assertTrue(createTime == category?.createTimestamp)
    }

    @Test
    fun update() {
    }

    @Test
    fun testUpdate() {
    }

    @Test
    fun updateSelectCount() {
    }

    @Test
    fun delete() {
    }
}