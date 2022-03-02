package com.danchoo.contents.domain.inspector.usecase

import com.danchoo.common.usecase.UseCase
import com.danchoo.contents.domain.model.ContentsModel
import com.danchoo.contents.domain.repository.ContentsRepository
import kotlinx.coroutines.CoroutineDispatcher
import java.util.*
import javax.inject.Inject

class ContentsListInsertUseCase @Inject constructor(
    private val repository: ContentsRepository,
    dispatcher: CoroutineDispatcher
) : UseCase<Unit, Unit>(dispatcher) {

    var index = 0
    override suspend fun execute(parameters: Unit) {
        val list = mutableListOf<ContentsModel.ContentsData>()
        val uuid = UUID.randomUUID().toString()
        list.add(
            ContentsModel.ContentsData(
                title = "$uuid / $index",
                createTimestamp = Date().time
            )
        )
        index++
        repository.insertContents(list)
    }
}
