package com.danchoo.date.presentation.ui.components.main.contents

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.navArgument
import com.danchoo.date.presentation.ui.components.main.contents.detail.ContentsDetail
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.pager.ExperimentalPagerApi


@ExperimentalPagerApi
@ExperimentalAnimationApi
fun NavGraphBuilder.addContentsNavGraph(
    modifier: Modifier = Modifier,
    onSelected: (String, NavBackStackEntry) -> Unit
) {
    composable(ContentsSections.LIST) { from ->
        Contents(modifier = modifier) {
            onSelected(it, from)
        }
    }
    composable(
        "${ContentsSections.DETAIL}/{${ContentsArgsKeys.CONTENTS_ID_KEY}}",
        arguments = listOf(navArgument(ContentsArgsKeys.CONTENTS_ID_KEY) {
            type = NavType.StringType
        })
    ) { from ->
        val arguments = requireNotNull(from.arguments)
        val contentsId = arguments.getString(ContentsArgsKeys.CONTENTS_ID_KEY)
        ContentsDetail(modifier = modifier) {
            onSelected(it, from)
        }
    }
//    composable(ContentsSections.SETTING.route) { from ->
//    }
}
