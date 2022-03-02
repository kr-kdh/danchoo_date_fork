package com.danchoo.date.presentation.home.category.editor

import android.content.Context
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.danchoo.commonutils.extension.deleteTempFile
import com.danchoo.commonutils.extension.getCacheDirByName
import com.danchoo.commonutils.extension.getTempFile
import com.danchoo.date.presentation.utils.extension.getFileProviderUri
import com.danchoo.date.presentation.utils.extension.launchResumed

class CategoryEditorState(
    val navController: NavController,
    val title: MutableState<String>,
    val description: MutableState<String>,
    val isVisibility: MutableState<Boolean>,
    val isShowMenuDialog: MutableState<Boolean>,
    val isShowCameraPermission: MutableState<Boolean>,
    val isShowReadStoragePermission: MutableState<Boolean>,
    val selectMediaUri: MutableState<Uri>
) {
    companion object {
        private const val CATEGORY_TEMP_IMAGE_FOLDER = "category_temp_image_folder"
    }

    fun popBackStack() {
        navController.launchResumed {
            popBackStack()
        }
    }

    fun isEnableConfirm() = title.value.isNotEmpty() && description.value.isNotEmpty()

    fun getMediaTempFileUri(context: Context) =
        context.getFileProviderUri(context.getTempFile(parent = CATEGORY_TEMP_IMAGE_FOLDER)).apply {
            selectMediaUri.value = this
        }

    fun getCacheDir(context: Context) = context.getCacheDirByName(CATEGORY_TEMP_IMAGE_FOLDER)

    fun deleteTempFile(context: Context) {
        context.deleteTempFile(CATEGORY_TEMP_IMAGE_FOLDER)
    }
}

@Composable
fun rememberCategoryEditorState(
    navController: NavController = rememberNavController(),
    title: MutableState<String> = rememberSaveable { mutableStateOf("") },
    description: MutableState<String> = rememberSaveable { mutableStateOf("") },
    isVisibility: MutableState<Boolean> = rememberSaveable { mutableStateOf(false) },
    isShowMenuDialog: MutableState<Boolean> = remember { mutableStateOf(false) },
    isShowCameraPermission: MutableState<Boolean> = remember { mutableStateOf(false) },
    isShowReadStoragePermission: MutableState<Boolean> = remember { mutableStateOf(false) },
    selectMediaUri: MutableState<Uri> = rememberSaveable { mutableStateOf(Uri.EMPTY) }
) = remember(
    navController,
    title,
    description,
    isVisibility,
    isShowMenuDialog,
    isShowCameraPermission,
    isShowReadStoragePermission,
    selectMediaUri
) {
    CategoryEditorState(
        navController,
        title,
        description,
        isVisibility,
        isShowMenuDialog,
        isShowCameraPermission,
        isShowReadStoragePermission,
        selectMediaUri
    )
}

