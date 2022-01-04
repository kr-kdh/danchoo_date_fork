package com.danchoo.date.presentation.ui.components.main.home.category

import android.Manifest
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.danchoo.date.presentation.ui.components.main.home.category.CategoryContract.CategoryViewEvent
import com.google.accompanist.permissions.rememberPermissionState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach


@Composable
fun CategoryDestination(
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

    val permissionsState = rememberPermissionState(
            Manifest.permission.CAMERA
    )

    /**
     * 처음
     * hasPermission = false
     * shouldShowRationale = false
     * permissionRequested = false
     *
     * 1 번 거부
     * hasPermission = false
     * shouldShowRationale = true
     * permissionRequested = true
     *
     * 2 번 거부
     * hasPermission = false
     * shouldShowRationale = false
     * permissionRequested = true
     *
     * 2 번 거부 후 껐다 켰을때
     * hasPermission = false
     * shouldShowRationale = false
     * permissionRequested = false
     *
     * 2 번 거부 후 껐다 키고 permission 요청 -> 시스템 팝업 나오지 않음
     * hasPermission = false
     * shouldShowRationale = false
     * permissionRequested = true
     */

    CategoryScreen(
        modifier = modifier,
        state = state,
        viewState = viewState,
        categoryDataList = categoryDataList
    ) { viewEvent ->

        when (viewEvent) {
            is CategoryViewEvent.ItemClick -> {
                permissionsState.launchPermissionRequest()
            }
            is CategoryViewEvent.TitleClick -> {
                permissionsState.launchPermissionRequest()
            }
            is CategoryViewEvent.AddCategory -> state.navigation(viewEvent)
            else -> Unit
        }
    }
}