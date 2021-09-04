package com.danchoo.date.presentation.ui.components.main.contents

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable


@ExperimentalAnimationApi
fun NavGraphBuilder.addContentsNavGraph(
    modifier: Modifier = Modifier,
    onSelected: (String, NavBackStackEntry) -> Unit
) {
    composable(ContentsSections.LIST.route) { from ->
        Contents(modifier = modifier) {
            onSelected(it, from)
        }
    }
//    composable(ContentsSections.DETAIL.route) { from ->
//    }
//    composable(ContentsSections.SETTING.route) { from ->
//    }
}
