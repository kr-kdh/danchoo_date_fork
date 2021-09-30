package com.danchoo.date.presentation.ui.components.main.editor.category

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.danchoo.date.presentation.ui.components.main.editor.category.CategoriesEditorDestinations.MAIN_ROUTE
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.navigation
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

/**
 * Destinations used in the ([ContentsNavGraph]).
 */
object CategoriesEditorDestinations {
    const val MAIN_ROUTE = "contents"
}

object CategoriesEditorSections {
    const val CREATE = "$MAIN_ROUTE/create"
    const val MODIFY = "$MAIN_ROUTE/modify"
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CategoriesEditorNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberAnimatedNavController(),
    startDestination: String = MAIN_ROUTE,
    mode: String = CategoriesEditorSections.CREATE
) {


    AnimatedNavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        navigation(
            route = MAIN_ROUTE,
            startDestination = mode
        ) {

            addCategoriesEditorNavGraph(
                modifier = modifier
            ) { categoryId, navBackStackEntry ->
//                navBackStackEntry.lifecycleIsResumed {
//                    navController.navigate("${CategoriesEditorSections.DETAIL}/$contentsId")
//                }
            }
        }
    }
}
