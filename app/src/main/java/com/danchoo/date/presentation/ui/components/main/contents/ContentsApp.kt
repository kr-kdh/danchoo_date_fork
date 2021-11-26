package com.danchoo.date.presentation.ui.components.main.contents

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.danchoo.components.theme.MyApplicationTheme
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@ExperimentalAnimationApi
@Preview
@Composable
fun ContentsApp(
) {
    MyApplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPaddingModifier ->
            ContentsNavGraph(
                modifier = Modifier.padding(innerPaddingModifier)
            )
        }
    }
}

