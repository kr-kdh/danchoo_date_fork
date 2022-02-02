package com.danchoo.commonutils.file.domain.inspector

import android.graphics.Bitmap
import android.net.Uri
import androidx.core.net.toUri
import com.danchoo.commonutils.file.domain.inspector.SaveBitmapUseCase.SaveBitmapParameter
import com.danchoo.commonutils.file.domain.inspector.SaveBitmapUseCase.SaveBitmapResult
import com.danchoo.inspactor.usecase.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import java.io.File
import java.io.FileOutputStream

class SaveBitmapUseCase(
    dispatcher: CoroutineDispatcher
) : UseCase<SaveBitmapParameter, SaveBitmapResult>(dispatcher) {

    override suspend fun execute(parameters: SaveBitmapParameter): SaveBitmapResult {
        if (parameters.bitmap == null) {
            return SaveBitmapResult(error = ERROR_BITMAP_NOT_FOUND)
        }

        val file = File(parameters.savePath)

        if (!file.exists()) {
            file.mkdirs()
        }

        val fileFullPath = parameters.savePath + File.separator + parameters.fileName
        val fileCacheItem = File(fileFullPath)

        fileCacheItem.createNewFile()
        val out = FileOutputStream(fileCacheItem)
        parameters.bitmap.compress(parameters.format, parameters.quality, out)
        out.close()

        return SaveBitmapResult(
            result = true,
            filePath = fileCacheItem.path,
            uri = fileCacheItem.toUri()
        )
    }

    data class SaveBitmapParameter(
        val bitmap: Bitmap?,
        val savePath: String,
        val fileName: String,
        val format: Bitmap.CompressFormat = Bitmap.CompressFormat.PNG,
        val quality: Int = 100
    )

    data class SaveBitmapResult(
        val result: Boolean = false,
        val error: Int = ERROR_NONE,
        val filePath: String = "",
        val uri: Uri = Uri.EMPTY
    )

    companion object {
        const val ERROR_NONE = 0
        const val ERROR_BITMAP_NOT_FOUND = 1
    }
}