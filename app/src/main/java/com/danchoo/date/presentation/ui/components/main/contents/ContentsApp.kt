package com.danchoo.date.presentation.ui.components.main.contents

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.danchoo.date.presentation.ui.theme.MyApplicationTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@ExperimentalAnimationApi
@Preview
@Composable
fun ContentsApp(
) {
    ProvideWindowInsets {
        MyApplicationTheme {
            val navController = rememberAnimatedNavController()

            Scaffold { innerPaddingModifier ->
                ContentsNavGraph(
                    navController = navController,
                    modifier = Modifier.padding(innerPaddingModifier)
                )
            }
        }
    }
}

