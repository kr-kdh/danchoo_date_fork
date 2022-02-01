package com.danchoo.commonutils.data.datasource

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import java.io.File
import java.io.FileOutputStream

class FileLocalDataSourceImpl(
    private val context: Context
) : FileLocalDataSource {
    override fun getFileName(path: String): String {
        if (path.isEmpty()) {
            return ""
        }

        return path.split("""/""").last()
    }

    override fun getFileName(uri: Uri): String {
        return context.contentResolver.query(uri, null, null, null, null)?.let { cursor ->
            val fileName = if (cursor.moveToFirst()) {
                cursor.getString(cursor.getColumnIndexOrThrow(OpenableColumns.DISPLAY_NAME))
            } else {
                getFileName(uri.toString())
            }

            cursor.close()

            fileName
        } ?: getFileName(uri.toString())
    }

    override fun copyFile(uri: Uri, destPath: String): File {
        val destFile = File(destPath)
        val inputStream =
            context.contentResolver.openInputStream(uri) ?: throw IllegalStateException()
        val outputStream = FileOutputStream(destFile)

        val buffer = ByteArray(BUFFER_SIZE)
        var read: Int

        while (inputStream.read(buffer).also { read = it } != -1) {
            outputStream.write(buffer, 0, read)
        }

        outputStream.flush()
        outputStream.close()

        inputStream.close()

        return destFile
    }

    companion object {
        private const val BUFFER_SIZE = 1024 * 1024
    }
}