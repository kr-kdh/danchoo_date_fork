package com.danchoo.commonutils.file

import java.io.File

interface FileConfiguration {
    val cacheDirAbsolutePath: String
    val cacheDirPath: String

    fun getCacheDir(): File

    fun getTempFileName(ext: String = TEMP_EXT): String

    companion object {
        private const val TEMP_EXT = "temp"
    }
}

