package com.danchoo.commonutils.file

import android.content.Context
import java.io.File
import javax.inject.Inject

internal class FileConfigurationImpl @Inject constructor(
    private val context: Context
) : FileConfiguration {

    override val cacheDirAbsolutePath: String
        get() = context.cacheDir.absolutePath

    override val cacheDirPath: String
        get() = context.cacheDir.path

    override fun getCacheDir(): File {
        return context.cacheDir
    }

    override fun getTempFileName(ext: String): String = "${System.currentTimeMillis()}.$ext"
}