package com.danchoo.date.presentation.ui.components.main.category

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.danchoo.date.presentation.ui.common.extension.launchResumed


class CategoryState(
    private val navController: NavController,
    val listState: LazyListState
) {
    fun navigation() {
        navController.launchResumed {

        }
    }
}

@Composable
fun rememberCategoryState(
    navController: NavController,
    listState: LazyListState = rememberLazyListState(),
) = remember {
    CategoryState(navController, listState)
}

