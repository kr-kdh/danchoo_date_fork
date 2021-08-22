package com.danchoo.date.domain.inspactor.usecase.main

import com.danchoo.date.domain.inspactor.usecase.base.UseCase
import com.danchoo.date.domain.model.CategoryModel
import com.danchoo.date.domain.repository.CategoryRepository
import kotlinx.coroutines.CoroutineDispatcher
import java.util.*
import javax.inject.Inject

class CategoryListInsertUseCase @Inject constructor(
    private val repository: CategoryRepository,
    dispatcher: CoroutineDispatcher
) : UseCase<Unit, Unit>(dispatcher) {

    var index = 0
    override suspend fun execute(parameters: Unit) {
        val list = mutableListOf<CategoryModel.CategoryData>()
        val uuid = UUID.randomUUID().toString()
        list.add(
            CategoryModel.CategoryData(
                categoryId = uuid,
                title = "$uuid / $index",
                timestamp = index.toLong()
            )
        )
        index++
        repository.insertCategory(list)
    }
}
