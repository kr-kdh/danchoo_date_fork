package com.danchoo.date.presentation.ui.components.main.contents

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.danchoo.date.presentation.ui.theme.MyApplicationTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@ExperimentalAnimationApi
@Preview
@Composable
fun ContentsApp(
) {
    ProvideWindowInsets {
        MyApplicationTheme {
            Scaffold { innerPaddingModifier ->
                ContentsNavGraph(
                    modifier = Modifier.padding(innerPaddingModifier)
                )
            }
        }
    }
}
