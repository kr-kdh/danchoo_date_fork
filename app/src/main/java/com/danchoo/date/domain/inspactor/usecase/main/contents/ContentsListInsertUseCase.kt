package com.danchoo.date.domain.inspactor.usecase.main.contents

import com.danchoo.date.domain.inspactor.usecase.base.UseCase
import com.danchoo.date.domain.model.ContentsModel
import com.danchoo.date.domain.repository.ContentsRepository
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
                contentsId = uuid,
                title = "$uuid / $index",
                timestamp = Date().time
            )
        )
        index++
        repository.insertContents(list)
    }
}
