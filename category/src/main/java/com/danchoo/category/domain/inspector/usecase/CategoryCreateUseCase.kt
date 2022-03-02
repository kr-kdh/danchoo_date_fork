package com.danchoo.category.domain.inspector.usecase

import android.net.Uri
import androidx.core.net.toUri
import com.danchoo.category.domain.inspector.usecase.CategoryCreateUseCase.CategoryCreateParameter
import com.danchoo.category.domain.model.CategoryModel
import com.danchoo.category.domain.repository.CategoryRepository
import com.danchoo.common.usecase.UseCase
import com.danchoo.commonutils.file.domain.repository.FileRepository
import kotlinx.coroutines.CoroutineDispatcher

class CategoryCreateUseCase(
    private val repository: CategoryRepository,
    private val fileRepository: FileRepository,
    coroutineDispatcher: CoroutineDispatcher
) : UseCase<CategoryCreateParameter, CategoryModel>(coroutineDispatcher) {

    override suspend fun execute(parameters: CategoryCreateParameter): CategoryModel {
        val categoryFolderPath = repository.getCategoryFolderPath()
        if (categoryFolderPath.isEmpty()) {
            throw IllegalStateException("CategoryFolder is not exist")
        }

        val copyPath = categoryFolderPath + fileRepository.getFileName(parameters.coverImageUri)
        val file = fileRepository.copyFile(parameters.coverImageUri, copyPath)

        return repository.createCategory(
            title = parameters.title,
            description = parameters.description,
            visibility = parameters.visibility,
            coverImageUri = file.toUri(),
            currentTimestamp = parameters.currentTimestamp
        ) ?: throw Exception()
    }

    data class CategoryCreateParameter(
        val title: String,
        val description: String = "",
        val visibility: Int = 0,
        val coverImageUri: Uri,
        val currentTimestamp: Long
    )
}