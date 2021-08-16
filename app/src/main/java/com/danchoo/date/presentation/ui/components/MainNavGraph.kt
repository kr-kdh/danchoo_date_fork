package com.danchoo.date.presentation.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.danchoo.date.presentation.ui.components.main.MainSections
import com.danchoo.date.presentation.ui.components.main.category.Category

/**
 * Destinations used in the ([MainNavGraph]).
 */
object MainDestinations {
    const val MAIN_ROUTE = "main"
}

@Preview
@Composable
fun MainNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = MainDestinations.MAIN_ROUTE,
) {
    NavHost(
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
            )
        }
//        composable(
//            "${MainDestinations.SNACK_DETAIL_ROUTE}/{$SNACK_ID_KEY}",
//            arguments = listOf(navArgument(SNACK_ID_KEY) { type = NavType.LongType })
//        ) { backStackEntry ->
//            val arguments = requireNotNull(backStackEntry.arguments)
//            val snackId = arguments.getLong(SNACK_ID_KEY)
//            SnackDetail(
//                snackId = snackId,
//                upPress = {
//                    navController.navigateUp()
//                }
//            )
//        }
    }
}

/**
 * If the lifecycle is not resumed it means this NavBackStackEntry already processed a nav event.
 *
 * This is used to de-duplicate navigation events.
 */
private fun NavBackStackEntry.lifecycleIsResumed() =
    this.lifecycle.currentState == Lifecycle.State.RESUMED


fun NavGraphBuilder.addMainGraph(
    modifier: Modifier = Modifier
) {
    composable(MainSections.CATEGORY.route) { from ->
        Category(modifier)
    }
    composable(MainSections.FAVORITE.route) { from ->
        Category(modifier)
    }
    composable(MainSections.SETTING.route) { from ->
        Category(modifier)
    }
}