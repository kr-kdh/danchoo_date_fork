package com.danchoo.date.presentation.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.danchoo.date.presentation.ui.components.main.HomeScreen
import com.danchoo.date.presentation.ui.components.main.MainNavGraph
import com.danchoo.date.presentation.ui.components.main.home.HomeBottomBar
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@Composable
fun MainApp() {
    val navController = rememberAnimatedNavController()
    val tabs = remember { HomeScreen.values() }

    Scaffold(
        bottomBar = { HomeBottomBar(navController = navController, tabs = tabs) },
    ) { innerPaddingModifier ->
        MainNavGraph(
            navHostController = navController,
            modifier = Modifier.padding(innerPaddingModifier)
        )
    }
}

