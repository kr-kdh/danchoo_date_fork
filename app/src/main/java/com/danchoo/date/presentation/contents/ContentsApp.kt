package com.danchoo.date.presentation.contents

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.danchoo.components.theme.MyApplicationTheme

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
