package com.danchoo.date.presentation.home.category

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.danchoo.date.presentation.home.category.CategoryContract.CategoryViewEvent
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach


@Composable
fun CategoryScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: CategoryViewModel = hiltViewModel()
) {

    val categoryDataList = viewModel.categoryList().collectAsLazyPagingItems()
    val viewState = viewModel.viewState.value
    val state = rememberCategoryState(navController)

    LaunchedEffect(key1 = Unit) {
        viewModel.sideEffect
            .onEach {

            }.collect()
    }



    CategoryScreenImpl(
        modifier = modifier,
        state = state,
        viewState = viewState,
        categoryDataList = categoryDataList
    ) { viewEvent ->

        when (viewEvent) {
            is CategoryViewEvent.OnItemClick -> {
            }
            is CategoryViewEvent.OnTitleClick -> {
            }
            is CategoryViewEvent.OnAddCategory -> state.navigation(viewEvent)
            else -> Unit
        }
    }
}