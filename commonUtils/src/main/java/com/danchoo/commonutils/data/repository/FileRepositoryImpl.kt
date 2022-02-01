package com.danchoo.commonutils.data.repository

import android.net.Uri
import com.danchoo.commonutils.data.datasource.FileLocalDataSource
import com.danchoo.commonutils.file.domain.repository.FileRepository
import java.io.File

class FileRepositoryImpl(
    private val localDataSource: FileLocalDataSource
): FileRepository {
    override fun getFileName(path: String): String {
        return localDataSource.getFileName(path)
    }

    override fun getFileName(uri: Uri): String {
        return localDataSource.getFileName(uri)
    }

    override fun copyFile(uri: Uri, destPath: String): File {
        return localDataSource.copyFile(uri, destPath)
    }
}