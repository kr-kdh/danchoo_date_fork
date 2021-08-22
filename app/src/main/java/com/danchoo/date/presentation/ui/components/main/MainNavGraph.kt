package com.danchoo.date.presentation.ui.components.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.danchoo.date.presentation.ui.common.extension.lifecycleIsResumed
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.navigation

/**
 * Destinations used in the ([MainNavGraph]).
 */
object MainDestinations {
    const val MAIN_ROUTE = "main"
    const val CATEGORY_DETAIL_ROUTE = "categoryDetail"
}

object MainRouteArgsKeys {
    const val CATEGORY_DETAIL_ID = "categoryId"
}

@ExperimentalAnimationApi
@Composable
fun MainNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = MainDestinations.MAIN_ROUTE,
) {

    AnimatedNavHost(
        navController = navController.apply {
            // Backstack 을 저장하지 않기 위함.
            enableOnBackPressed(false)
        },
        startDestination = startDestination,
        modifier = modifier
    ) {
        navigation(
            route = MainDestinations.MAIN_ROUTE,
            startDestination = MainSections.CATEGORY.route
        ) {

            addMainGraph(
                modifier = modifier
            ) { categoryId, navBackStackEntry ->
                navBackStackEntry.lifecycleIsResumed {
                    navController.navigate("${MainDestinations.CATEGORY_DETAIL_ROUTE}/$categoryId")
                }
            }
        }

        addCategoryDetail {

        }
    }
}





