package com.danchoo.date.presentation.sample.components.cardview

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.danchoo.components.theme.MyApplicationTheme
import com.danchoo.components.ui.cardview.CardView
import com.danchoo.components.ui.cardview.CardViewContents
import com.danchoo.components.ui.cardview.CardViewContentsType

@Preview("light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun CardPreviewPreview() {
    MyApplicationTheme {
        CardView(modifier = Modifier) {
            CardViewContents(
                type = CardViewContentsType.Normal,
                title = "Title",
                description = "description"
            )
        }
    }
}
