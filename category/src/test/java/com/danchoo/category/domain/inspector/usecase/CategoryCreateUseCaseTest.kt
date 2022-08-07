package com.danchoo.category.domain.inspector.usecase

import android.net.Uri
import com.danchoo.category.domain.inspector.usecase.CategoryCreateUseCase.CategoryCreateParameter
import com.danchoo.category.domain.model.CategoryModel
import com.danchoo.category.domain.repository.CategoryRepository
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito

internal class CategoryCreateUseCaseTest {


    private lateinit var mockRepository: CategoryRepository
    private lateinit var useCase: CategoryCreateUseCase
    private lateinit var uri: Uri

    @BeforeEach
    fun setUp() {
        mockRepository = mockk()
        uri = mockk()
        useCase = CategoryCreateUseCase(mockRepository, Dispatchers.IO)
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun categoryCreate() = runBlocking {
        val title = "title"
        val description = "description"
        val visibility = 1
        val coverImageUri = "www.naver.com"
        val currentTimestamp = 1111L

        Mockito.`when`(uri.toString()).thenReturn(coverImageUri)
        Mockito.`when`(
            mockRepository.createCategory(
                title = title,
                description = description,
                visibility = visibility,
                coverImageUri = uri,
                currentTimestamp = currentTimestamp
            )
        ).thenReturn(
            CategoryModel(
                title = title,
                description = description,
                visibility = visibility,
                coverImageUri = coverImageUri,
                createTimestamp = currentTimestamp,
                lastModifiedTimestamp = currentTimestamp
            )
        )

        val result = useCase(
            CategoryCreateParameter(
                title = title,
                description = description,
                visibility = visibility,
                coverImageUri = uri,
                currentTimestamp = currentTimestamp
            )
        )

        assert(result is Result.Success)
        assert((result as Result.Success).data.title == title)
        assert(result.data.description == description)
        assert(result.data.visibility == visibility)
        assert(result.data.coverImageUri == coverImageUri)
        assert(result.data.createTimestamp == currentTimestamp)
        assert(result.data.lastModifiedTimestamp == currentTimestamp)
    }

}