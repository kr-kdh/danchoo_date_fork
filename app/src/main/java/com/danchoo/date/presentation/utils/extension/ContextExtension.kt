package com.danchoo.date.presentation.utils.extension

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import com.danchoo.date.R
import java.io.File

fun Context.getFileProviderUri(file: File): Uri =
    FileProvider.getUriForFile(
        this,
        getString(R.string.file_provider_authority),
        file
    )