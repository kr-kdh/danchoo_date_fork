package com.danchoo.commonutils.file.domain.repository

interface FileRepository {

    fun getFilePath(path: String): String

    fun getFileName(path: String): String
}