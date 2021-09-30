package com.danchoo.date.presentation.ui.components.main.editor.category

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.danchoo.date.presentation.ui.components.main.MainBottomBar
import com.danchoo.date.presentation.ui.components.main.MainSections
import com.danchoo.date.presentation.ui.theme.MyApplicationTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CategoriesEditorApp() {
    MyApplicationTheme {
        val navController = rememberAnimatedNavController()
        val tabs = remember { MainSections.values() }

        Scaffold(
            bottomBar = { MainBottomBar(navController = navController, tabs = tabs) },
        ) { innerPaddingModifier ->
            CategoriesEditorNavGraph(
                navController = navController,
                modifier = Modifier.padding(innerPaddingModifier)
            )
        }
    }
}