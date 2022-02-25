package com.danchoo.date.presentation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.danchoo.date.R
import com.danchoo.date.presentation.home.category.editor.addCategoryEditorNavGraph


/**
 * Destinations used in the ([MainNavGraph]).
 */
object MainRoute {
    const val HOME_ROUTE = "home"

    const val CATEGORY_EDITOR_ROUTE = "categoryEditor"

    const val CATEGORY_DETAIL_ROUTE = "categoryDetail"

    const val COMMON_ROUTE = "common"
}

enum class HomeScreen(
    @StringRes val title: Int,
    val icon: ImageVector,
    val route: String
) {
    CATEGORY(
        R.string.fragment_category_nav_title,
        Icons.Outlined.Home,
        "${MainRoute.HOME_ROUTE}/category"
    ),
    FAVORITE(
        R.string.fragment_favorite_nav_title,
        Icons.Outlined.Search,
        "${MainRoute.HOME_ROUTE}/favorite"
    ),
    SETTING(
        R.string.fragment_setting_nav_title,
        Icons.Outlined.ShoppingCart,
        "${MainRoute.HOME_ROUTE}/setting"
    ),
}

/**
 * Destinations used in the ([addCategoryEditorNavGraph]).
 */
object CategoryEditorScreen {
    const val CREATE = "${MainRoute.CATEGORY_EDITOR_ROUTE}/create"
    const val MODIFY = "${MainRoute.CATEGORY_DETAIL_ROUTE}/modify"
}

object CommonScreen {
    const val GALLERY = "${MainRoute.COMMON_ROUTE}/gallery"
}


object MainRouteArgsKeys {
    const val CATEGORY_DETAIL_ID = "categoryId"
}




