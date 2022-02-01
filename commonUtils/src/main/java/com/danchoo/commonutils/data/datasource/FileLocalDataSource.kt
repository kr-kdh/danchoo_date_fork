package com.danchoo.commonutils.data.datasource

import android.net.Uri
import java.io.File
import java.io.IOException

interface FileLocalDataSource {

    fun getFileName(path: String): String

    fun getFileName(uri: Uri): String

    @Throws(IOException::class, IllegalStateException::class)
    fun copyFile(uri: Uri, destPath: String): File
}