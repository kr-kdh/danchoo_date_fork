package com.danchoo.date.presentation.contents

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.danchoo.date.presentation.ContentsArgsKeys
import com.danchoo.date.presentation.ContentsScreen
import com.danchoo.date.presentation.MainRoute.CONTENTS_ROUTE
import com.danchoo.date.presentation.contents.detail.ContentsDetail
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation


fun NavGraphBuilder.addContentsNavGraph(
    modifier: Modifier,
    navHostController: NavHostController
) {
    navigation(
        route = CONTENTS_ROUTE,
        startDestination = ContentsScreen.LIST
    ) {
        composable(
            route = ContentsScreen.getListRoute(),
            arguments = listOf(navArgument(ContentsArgsKeys.CONTENTS_CATEGORY_ID) {
                type = NavType.LongType
            })
        ) {
            ContentsScreen(modifier = modifier) {
            }
        }

        composable(
            route = ContentsScreen.getDetailRoute(),
            arguments = listOf(navArgument(ContentsArgsKeys.CONTENTS_ID) {
                type = NavType.LongType
            })
        ) { from ->
            val arguments = requireNotNull(from.arguments)
            val contentsId = arguments.getLong(ContentsArgsKeys.CONTENTS_ID)
            ContentsDetail(modifier) {
            }
        }
    }
}
