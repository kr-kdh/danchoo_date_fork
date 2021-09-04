package com.danchoo.date.presentation.ui.components.main.contents

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.danchoo.date.presentation.ui.common.extension.lifecycleIsResumed
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.navigation

/**
 * Destinations used in the ([ContentsNavGraph]).
 */
object ContentsDestinations {
    const val MAIN_ROUTE = "main"
}

enum class ContentsSections(
    val route: String
) {
    LIST("main/list"),
    DETAIL("main/favorite"),
    SETTING("main/setting"),
}

@ExperimentalAnimationApi
@Composable
fun ContentsNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = ContentsDestinations.MAIN_ROUTE,
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
            route = ContentsDestinations.MAIN_ROUTE,
            startDestination = ContentsSections.LIST.route
        ) {

            addContentsNavGraph(
                modifier = modifier
            ) { contentId, navBackStackEntry ->
                navBackStackEntry.lifecycleIsResumed {
                }
            }
        }
    }
}
