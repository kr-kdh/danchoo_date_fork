package com.danchoo.date.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.danchoo.date.presentation.home.HomeNavActions
import com.danchoo.date.presentation.home.category.editor.CategoryEditorActions
import com.danchoo.date.presentation.utils.extension.launchResumed

class MainNavGraphState(
    private val navController: NavController,
) : HomeNavActions, CategoryEditorActions {
    override fun onClickCategoryAdd() {
        navController.launchResumed {
            navigate(CategoryEditorScreen.CREATE)
        }
    }

    override fun onClickCategory(categoryId: Long) {
    }

    override fun moveToGallery() {
        navController.launchResumed {
            navigate(CommonScreen.GALLERY)
        }
    }
}

@Composable
fun rememberMainNavGraphState(
    navController: NavController = rememberNavController()
) = remember(navController) {
    MainNavGraphState(navController)
}