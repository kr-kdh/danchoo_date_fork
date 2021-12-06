package com.danchoo.date.presentation.ui.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.danchoo.date.presentation.ui.components.main.MainBottomBar
import com.danchoo.date.presentation.ui.components.main.MainNavGraph
import com.danchoo.date.presentation.ui.components.main.MainSections
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@ExperimentalAnimationApi
@Composable
fun MainApp() {
    val navController = rememberAnimatedNavController()
    val tabs = remember { MainSections.values() }

    Scaffold(
        bottomBar = { MainBottomBar(navController = navController, tabs = tabs) },
    ) { innerPaddingModifier ->
        MainNavGraph(
            navHostController = navController,
            modifier = Modifier.padding(innerPaddingModifier)
        )
    }
}

