package com.danchoo.date.presentation.home.category.editor

import android.content.Context
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import com.danchoo.commonutils.extension.deleteTempFile
import com.danchoo.commonutils.extension.getCacheDirByName
import com.danchoo.commonutils.extension.getTempFile
import com.danchoo.date.presentation.utils.extension.getFileProviderUri

class CategoryEditorState(
    val context: Context,
    val isShowMenuDialog: MutableState<Boolean>,
    val isShowCameraPermission: MutableState<Boolean>,
    val isShowReadStoragePermission: MutableState<Boolean>,
    val selectMediaUri: MutableState<Uri>
) {
    companion object {
        private const val CATEGORY_TEMP_IMAGE_FOLDER = "category_temp_image_folder"
    }

    fun getMediaTempFileUri() =
        context.getFileProviderUri(context.getTempFile(parent = CATEGORY_TEMP_IMAGE_FOLDER)).apply {
            selectMediaUri.value = this
        }

    fun getCacheDir() = context.getCacheDirByName(CATEGORY_TEMP_IMAGE_FOLDER)

    fun deleteTempFile() {
        context.deleteTempFile(CATEGORY_TEMP_IMAGE_FOLDER)
    }
}

@Composable
fun rememberCategoryEditorState(
    context: Context = LocalContext.current,
    isShowMenuDialog: MutableState<Boolean> = remember { mutableStateOf(false) },
    isShowCameraPermission: MutableState<Boolean> = remember { mutableStateOf(false) },
    isShowReadStoragePermission: MutableState<Boolean> = remember { mutableStateOf(false) },
    selectMediaUri: MutableState<Uri> = rememberSaveable { mutableStateOf(Uri.EMPTY) }
) = remember(
    context,
    isShowMenuDialog,
    isShowCameraPermission,
    isShowReadStoragePermission,
    selectMediaUri
) {
    CategoryEditorState(
        context,
        isShowMenuDialog,
        isShowCameraPermission,
        isShowReadStoragePermission,
        selectMediaUri
    )
}

