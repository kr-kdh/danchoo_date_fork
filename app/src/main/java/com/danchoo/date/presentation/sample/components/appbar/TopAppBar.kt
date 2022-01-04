package com.danchoo.date.presentation.sample.components.appbar

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.danchoo.components.theme.MyApplicationTheme
import com.danchoo.components.ui.appbar.BackTopAppBar


@Preview("light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun TopAppbarPreview() {
    MyApplicationTheme {
        Column {
            BackTopAppBar(
                modifier = Modifier,
                title = {
                    Text(text = "title")
                }
            )
        }
    }
}