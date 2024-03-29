package com.danchoo.commonutils.file.domain.repository

import android.net.Uri
import java.io.File

interface FileRepository {

    fun getFileName(path: String): String

    fun getFileName(uri: Uri): String

    fun copyFile(uri: Uri, destPath: String): File
}