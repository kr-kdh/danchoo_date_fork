package com.danchoo.date.presentation.contents

import androidx.compose.ui.Modifier
import androidx.navigation.*
import com.danchoo.date.presentation.contents.ContentsDestinations.MAIN_ROUTE
import com.danchoo.date.presentation.contents.detail.ContentsDetail
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation

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

fun NavGraphBuilder.addContentsNavGraph(
    modifier: Modifier,
    navHostController: NavHostController
) {
    navigation(
        route = MAIN_ROUTE,
        startDestination = ContentsSections.LIST
    ) {
        composable(ContentsSections.LIST) { from ->
            ContentsScreen(modifier = modifier) {
            }
        }

        composable(
            route = "${ContentsSections.DETAIL}/{${ContentsArgsKeys.CONTENTS_ID_KEY}}",
            arguments = listOf(navArgument(ContentsArgsKeys.CONTENTS_ID_KEY) {
                type = NavType.LongType
            })
        ) { from ->
            val arguments = requireNotNull(from.arguments)
            val contentsId = arguments.getLong(ContentsArgsKeys.CONTENTS_ID_KEY)
            ContentsDetail(modifier) {
            }
        }
    }
}
