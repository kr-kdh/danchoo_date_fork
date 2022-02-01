package com.danchoo.date.presentation.ui.components.main.editor.category

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavController
import com.danchoo.date.presentation.ui.common.extension.launchResumed
import com.danchoo.date.presentation.ui.components.main.CategoryEditorScreen

class CategoryEditorState(
    val navController: NavController,
    val title: MutableState<String>,
    val description: MutableState<String>,
    val isVisibility: MutableState<Boolean>,
    val isShowMenuDialog: MutableState<Boolean>,
    val isShowCameraPermission: MutableState<Boolean>,
    val isShowReadStoragePermission: MutableState<Boolean>
) {
    fun popBackStack() {
        navController.launchResumed {
            popBackStack()
        }
    }

    fun moveToGallery() {
        navController.launchResumed {
            navigate(CategoryEditorScreen.GALLERY)
        }
    }

    fun isEnableConfirm(): Boolean {
        return title.value.isNotEmpty() && description.value.isNotEmpty()
    }
}


@Composable
fun rememberCategoryEditorState(
    navController: NavController,
    title: MutableState<String> = rememberSaveable { mutableStateOf("") },
    description: MutableState<String> = rememberSaveable { mutableStateOf("") },
    isVisibility: MutableState<Boolean> = rememberSaveable { mutableStateOf(false) },
    isShowMenuDialog: MutableState<Boolean> = remember { mutableStateOf(false) },
    isShowCameraPermission: MutableState<Boolean> = remember { mutableStateOf(false) },
    isShowReadStoragePermission: MutableState<Boolean> = remember { mutableStateOf(false) },
) = remember(
    navController,
    title,
    description,
    isVisibility,
    isShowMenuDialog,
    isShowCameraPermission,
    isShowReadStoragePermission
) {
    CategoryEditorState(
        navController,
        title,
        description,
        isVisibility,
        isShowMenuDialog,
        isShowCameraPermission,
        isShowReadStoragePermission
    )
}

