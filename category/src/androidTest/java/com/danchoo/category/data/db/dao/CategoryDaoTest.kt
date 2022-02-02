package com.danchoo.category.data.db.dao

import android.content.Context
import android.view.View
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.danchoo.category.data.db.TestAppDatabase
import com.danchoo.category.data.mapper.toEntity
import com.danchoo.category.domain.model.CategoryModel
import org.junit.Assert
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.IOException

internal class CategoryDaoTest {

    private lateinit var db: TestAppDatabase
    private lateinit var dao: CategoryDao

    @BeforeEach
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room
            .inMemoryDatabaseBuilder(context, TestAppDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        dao = db.categoryDao()

    }

    @AfterEach
    @Throws(IOException::class)
    fun tearDown() {
        dao.deleteAll()
        db.clearAllTables()
        db.close()
    }

    @Test
    fun testInsertCategory() {
        val categoryModel = CategoryModel(
            title = "categoryModel title",
            description = "categoryModel description",
            visibility = View.VISIBLE
        )

        val category = categoryModel.toEntity()

        val id = dao.insert(category)
        val result = dao.getCategory(id)

        Assert.assertNotNull(result)
        Assert.assertTrue(id == result!!.categoryId)
        Assert.assertTrue(categoryModel.title == result.title)
        Assert.assertTrue(categoryModel.description == result.description)
        Assert.assertTrue(categoryModel.visibility == result.visibility)

        dao.deleteAll()
    }

    @Test
    fun testInsertAllCategory() {
        val list = mutableListOf<CategoryModel>()

        for (index in 0..10) {
            list.add(
                CategoryModel(
                    title = "categoryModel title $index",
                    description = "categoryModel description $index",
                    visibility = View.VISIBLE
                )
            )
        }

        val categoryList = list.map { it.toEntity() }
        dao.insertAll(categoryList)

        val resultList = dao.getCategoryList()
        Assert.assertTrue(resultList.size == categoryList.size)

        dao.deleteAll()
    }

    @Test
    fun testGetCreateTimestampByOffset() {
        val list = mutableListOf<CategoryModel>()

        val timestamp = System.currentTimeMillis()
        for (index in 0..10) {
            list.add(
                CategoryModel(
                    title = "categoryModel title $index",
                    description = "categoryModel description $index",
                    visibility = View.VISIBLE,
                    createTimestamp = timestamp + index
                )
            )
        }

        val categoryList = list.map { it.toEntity() }
        dao.insertAll(categoryList)

        for (index in 0..10 ) {
            val result = dao.getCreateTimestampByOffset(index)
            Assert.assertTrue(result == timestamp + index)
        }

        dao.deleteAll()
    }

    @Test
    fun testUpdateCategory() {
        val categoryModel = CategoryModel(
            title = "categoryModel title",
            description = "categoryModel description",
            visibility = View.VISIBLE
        )

        val category = categoryModel.toEntity()

        val id = dao.insert(category)
        val insertCategory = dao.getCategory(id)

        Assert.assertNotNull(insertCategory)
        Assert.assertTrue(id == insertCategory!!.categoryId)
        Assert.assertTrue(categoryModel.title == insertCategory.title)
        Assert.assertTrue(categoryModel.description == insertCategory.description)
        Assert.assertTrue(categoryModel.visibility == insertCategory.visibility)

        val updateCategory = insertCategory.copy(title = "update")
        dao.update(updateCategory)

        val result = dao.getCategory(id)

        Assert.assertNotNull(result)
        Assert.assertTrue(id == result!!.categoryId)
        Assert.assertTrue(updateCategory.title == result.title)
        Assert.assertTrue(updateCategory.description == result.description)
        Assert.assertTrue(updateCategory.visibility == result.visibility)

        dao.deleteAll()
    }

    @Test
    fun testUpdateReadCount() {
        val categoryModel = CategoryModel(
            title = "categoryModel title",
            description = "categoryModel description",
            visibility = View.VISIBLE
        )

        val category = categoryModel.toEntity()

        val id = dao.insert(category)
        val insertCategory = dao.getCategory(id)

        Assert.assertNotNull(insertCategory)

        val timestamp = System.currentTimeMillis()
        dao.updateReadCount(
            categoryId = insertCategory!!.categoryId,
            readCount = 10,
            lastReadTimestamp = timestamp
        )

        val result = dao.getCategory(id)

        Assert.assertTrue(id == result!!.categoryId)
        Assert.assertTrue(insertCategory.title == result.title)
        Assert.assertTrue(insertCategory.description == result.description)
        Assert.assertTrue(insertCategory.visibility == result.visibility)
        Assert.assertTrue(10L == result.readCount)
        Assert.assertTrue(timestamp == result.lastReadTimestamp)

        dao.deleteAll()
    }

    @Test
    fun testDeleteCategory() {
        val categoryModel = CategoryModel(
            title = "categoryModel title",
            description = "categoryModel description",
            visibility = View.VISIBLE
        )

        val category = categoryModel.toEntity()

        val id = dao.insert(category)
        val insertCategory = dao.getCategory(id)

        Assert.assertNotNull(insertCategory)

        dao.delete(insertCategory!!.categoryId)
        val result = dao.getCategory(id)

        Assert.assertNull(result)
    }

    @Test
    fun testDeleteAll() {
        val list = mutableListOf<CategoryModel>()

        for (index in 0..10) {
            list.add(
                CategoryModel(
                    title = "categoryModel title $index",
                    description = "categoryModel description $index",
                    visibility = View.VISIBLE
                )
            )
        }

        val categoryList = list.map { it.toEntity() }
        dao.insertAll(categoryList)

        val insertList = dao.getCategoryList()
        Assert.assertTrue(insertList.size == categoryList.size)

        dao.deleteAll()

        val result = dao.getCategoryList()
        Assert.assertTrue(result.isEmpty())

    }
}
