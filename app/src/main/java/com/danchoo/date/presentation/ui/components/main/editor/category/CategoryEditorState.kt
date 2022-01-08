package com.danchoo.date.presentation.ui.components.main.editor.category

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavController
import com.danchoo.date.presentation.ui.common.extension.launchResumed

class CategoryEditorState(
    val navController: NavController,
    val title: MutableState<String>,
    val description: MutableState<String>,
    val isVisibility: MutableState<Boolean>,
    val isShowMenuDialog: MutableState<Boolean>,
    val isShowPermission: MutableState<Boolean>
) {
    fun popBackStack() {
        navController.launchResumed {
            popBackStack()
        }
    }
}


@Composable
fun rememberCategoryEditorState(
    navController: NavController,
    title: MutableState<String> = rememberSaveable { mutableStateOf("") },
    description: MutableState<String> = rememberSaveable { mutableStateOf("") },
    isVisibility: MutableState<Boolean> = rememberSaveable { mutableStateOf(false) },
    isShowMenuDialog: MutableState<Boolean> = rememberSaveable { mutableStateOf(false) },
    isShowPermission: MutableState<Boolean> = remember { mutableStateOf(false) }
) = remember(
    navController,
    title,
    description,
    isVisibility,
    isShowMenuDialog,
    isShowPermission
) {
    CategoryEditorState(
        navController,
        title,
        description,
        isVisibility,
        isShowMenuDialog,
        isShowPermission
    )
}

