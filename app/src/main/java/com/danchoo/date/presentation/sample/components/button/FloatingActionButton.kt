package com.danchoo.date.presentation.sample.components.button

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.danchoo.components.theme.MyApplicationTheme
import com.danchoo.components.ui.button.AddFloatingActionButton

@Preview("light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ExpandButtonPreview() {
    MyApplicationTheme {
        AddFloatingActionButton() {}
    }
}