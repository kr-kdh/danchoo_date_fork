package com.danchoo.commonutils.extension

import android.content.Context
import java.io.File

fun Context.getTempFile(
    parent: String = "",
    prefix: String = "temp_"
): File {
    return File.createTempFile(
        prefix,
        null,
        File(getCacheDirByName(parent).absolutePath)
    )
}

fun Context.getCacheDirByName(
    folderName: String = ""
): File {
    val folderPath = if (folderName.isNotEmpty()) {
        cacheDir.absolutePath + File.separator + folderName
    } else {
        cacheDir.absolutePath
    }

    val folder = File(folderPath)
    if (!folder.exists()) {
        folder.mkdirs()
    }

    return folder
}

fun Context.deleteTempFile(parent: String = "") {
    val folderPath = cacheDir.absolutePath + File.separator + parent
    val folder = File(folderPath)
    if (folder.exists()) {
        folder.deleteRecursively()
    }
}