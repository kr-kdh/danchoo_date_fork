package com.danchoo.date.presentation.sample.components.dialog

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.danchoo.components.theme.MyApplicationTheme
import com.danchoo.components.ui.dialog.ListDialogContents

@Preview("light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun CardPreviewPreview() {
    MyApplicationTheme {
        val items = mutableListOf<String>()

        for (index in 0..20) {
            items.add("item $index")
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            ListDialogContents(
                items,
                MaterialTheme.colors.onSurface
            )
        }
    }
}
