package com.danchoo.date.presentation.ui.components.main.contents

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.danchoo.date.presentation.ui.common.extension.lifecycleIsResumed
import com.danchoo.date.presentation.ui.components.main.contents.ContentsDestinations.MAIN_ROUTE
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.navigation
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.pager.ExperimentalPagerApi

/**
 * Destinations used in the ([ContentsNavGraph]).
 */
object ContentsDestinations {
    const val MAIN_ROUTE = "contents"
}

object ContentsSections {
    const val LIST = "$MAIN_ROUTE/list"
    const val DETAIL = "$MAIN_ROUTE/detail"
    const val SETTING = "$MAIN_ROUTE/setting"
}


object ContentsArgsKeys {
    const val CONTENTS_ID_KEY = "contentsId"
}

@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
fun ContentsNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberAnimatedNavController(),
    startDestination: String = ContentsDestinations.MAIN_ROUTE,
) {

    AnimatedNavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        navigation(
            route = ContentsDestinations.MAIN_ROUTE,
            startDestination = ContentsSections.LIST
        ) {

            addContentsNavGraph(
                modifier = modifier
            ) { contentsId, navBackStackEntry ->
                navBackStackEntry.lifecycleIsResumed {
                    navController.navigate("${ContentsSections.DETAIL}/$contentsId")
                }
            }
        }
    }
}
