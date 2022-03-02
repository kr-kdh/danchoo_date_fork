package com.danchoo.commonutils.file.domain.inspector

import android.net.Uri
import androidx.core.net.toUri
import com.danchoo.common.usecase.UseCase
import com.danchoo.commonutils.file.domain.inspector.SaveFileUseCase.SaveFileParameter
import com.danchoo.commonutils.file.domain.inspector.SaveFileUseCase.SaveFileResult
import com.danchoo.commonutils.file.domain.repository.FileRepository
import kotlinx.coroutines.CoroutineDispatcher
import java.io.File

class SaveFileUseCase(
    private val repository: FileRepository,
    dispatcher: CoroutineDispatcher
) : UseCase<SaveFileParameter, SaveFileResult>(dispatcher) {

    override suspend fun execute(parameters: SaveFileParameter): SaveFileResult {
        val file = File(parameters.savePath)

        if (!file.exists()) {
            file.mkdirs()
        }

        var copyPath = parameters.savePath + File.separator + repository.getFileName(parameters.uri)
        copyPath = if (parameters.addTimeStamp) {
            copyPath + "_" + System.currentTimeMillis()
        } else {
            copyPath
        }

        val copyFile = repository.copyFile(parameters.uri, copyPath)

        return SaveFileResult(
            result = true,
            filePath = copyFile.path,
            uri = copyFile.toUri()
        )
    }

    override suspend fun onError(e: Exception) {
        super.onError(e)
    }

    data class SaveFileParameter(
        val uri: Uri,
        val savePath: String,
        val addTimeStamp: Boolean = true
    )

    data class SaveFileResult(
        val result: Boolean = false,
        val filePath: String,
        val uri: Uri
    )
}