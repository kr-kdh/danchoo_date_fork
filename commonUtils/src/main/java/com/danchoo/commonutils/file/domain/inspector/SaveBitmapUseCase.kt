package com.danchoo.commonutils.file.domain.inspector

import android.graphics.Bitmap
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

class SaveBitmapUseCase {
    operator fun invoke(
        bitmap: Bitmap?,
        path: String,
        fileName: String,
        format: Bitmap.CompressFormat = Bitmap.CompressFormat.PNG,
        quality: Int = 100
    ): SaveBitmapUseCaseResult {
        if (bitmap == null) {
            return SaveBitmapUseCaseResult(error = ERROR_BITMAP_NOT_FOUND)
        }

        val file = File(path)

        if (!file.exists()) {
            file.mkdirs()
        }

        val fileFullPath = path + File.separator + fileName
        val fileCacheItem = File(fileFullPath)

        var out: OutputStream? = null
        try {
            fileCacheItem.createNewFile()
            out = FileOutputStream(fileCacheItem)
            bitmap.compress(format, quality, out)
        } catch (e: Exception) {
            e.printStackTrace()
            return SaveBitmapUseCaseResult(
                error = ERROR_BITMAP_SAVE_FAIL,
                throwable = e
            )
        } finally {
            try {
                out?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        return SaveBitmapUseCaseResult(
            result = true,
            filePath = fileFullPath
        )
    }

    data class SaveBitmapUseCaseResult(
        val result: Boolean = false,
        val error: Int = ERROR_NONE,
        val throwable: Throwable? = null,
        val filePath: String = ""
    )

    companion object {
        const val ERROR_NONE = 0
        const val ERROR_BITMAP_NOT_FOUND = 1
        const val ERROR_BITMAP_SAVE_FAIL = 2
    }
}