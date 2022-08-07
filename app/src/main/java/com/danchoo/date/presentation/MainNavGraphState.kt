package com.danchoo.date.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.danchoo.date.presentation.contents.ContentsNavActions
import com.danchoo.date.presentation.home.category.editor.CategoryEditorNavActions
import com.danchoo.date.presentation.home.category.graph.HomeNavActions
import com.danchoo.date.presentation.utils.extension.launchResumed

class MainNavGraphState(
    private val navController: NavController,
) : HomeNavActions, CategoryEditorNavActions,ContentsNavActions {
    override fun onClickCategoryAdd() {
        navController.launchResumed {
            navigate(CategoryEditorScreen.CREATE)
        }
    }

    override fun onClickCategory(categoryId: Long) {
        navController.launchResumed {
            navigate(ContentsScreen.getListDestination(categoryId = categoryId))
        }
    }

    override fun moveGallery() {
        navController.launchResumed {
            navigate(CommonScreen.GALLERY)
        }
    }

    override fun moveTagList() {
        navController.launchResumed {
            navigate(CommonScreen.TAG_LIST)
        }
    }
}

@Composable
fun rememberMainNavGraphState(
    navController: NavController = rememberNavController()
) = remember(navController) {
    MainNavGraphState(navController)
}