package com.danchoo.date.presentation.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.danchoo.date.presentation.ui.components.main.MainBottomBar
import com.danchoo.date.presentation.ui.components.main.MainSections
import com.danchoo.date.presentation.ui.theme.MyApplicationTheme
import com.google.accompanist.insets.ProvideWindowInsets

@Preview
@Composable
fun MainApp() {
    ProvideWindowInsets {
        MyApplicationTheme {
            val tabs = remember { MainSections.values() }
            val navController = rememberNavController()
            Scaffold(
                bottomBar = { MainBottomBar(navController = navController, tabs = tabs) },
            ) { innerPaddingModifier ->
                MainNavGraph(
                    navController = navController,
                    modifier = Modifier.padding(innerPaddingModifier)
                )
            }
        }
    }
}

