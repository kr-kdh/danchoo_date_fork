package com.danchoo.date.domain.inspactor.usecase.main.category

import com.danchoo.date.domain.model.CategoryModel
import com.danchoo.date.domain.repository.CategoryRepository
import com.danchoo.inspactor.usecase.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import java.util.*
import javax.inject.Inject

class CategoryListInsertUseCase @Inject constructor(
    private val repository: CategoryRepository,
    dispatcher: CoroutineDispatcher
) : UseCase<Unit, Unit>(dispatcher) {

    var index = 0
    override suspend fun execute(parameters: Unit) {
        val list = mutableListOf<CategoryModel>()
        val uuid = UUID.randomUUID().toString()
        list.add(
            CategoryModel(
                title = "$uuid / $index",
                lastModifiedTimestamp = Date().time
            )
        )
        index++
    }
}
