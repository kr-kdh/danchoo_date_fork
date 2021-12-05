package com.danchoo.date.presentation.sample.components.appbar

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danchoo.components.theme.MyApplicationTheme
import com.danchoo.components.ui.appbar.TopAppBar
import com.danchoo.components.ui.appbar.TopAppbarType


@Preview("light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun TopAppbarPreview() {
    MyApplicationTheme {
        Column {
            TopAppBar(
                modifier = Modifier,
                type = TopAppbarType.Title,
                title = "TopAppbarPreview"
            )

            Spacer(Modifier.height(30.dp))

            TopAppBar(
                modifier = Modifier,
                type = TopAppbarType.Back,
                title = "TopAppbarPreview"
            )
        }
    }
}