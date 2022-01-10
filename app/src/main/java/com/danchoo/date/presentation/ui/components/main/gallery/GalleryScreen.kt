package com.danchoo.date.presentation.ui.components.main.gallery

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun GalleryScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: GalleryViewModel = hiltViewModel()
) {

    val viewState = viewModel.viewState.value

    GalleryScreenImpl(
        modifier = modifier,
        viewState = viewState
    ) {

    }
}