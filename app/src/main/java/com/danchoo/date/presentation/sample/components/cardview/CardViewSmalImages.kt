package com.danchoo.date.presentation.sample.components.cardview

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.danchoo.components.theme.MyApplicationTheme
import com.danchoo.components.ui.cardview.CardView
import com.danchoo.components.ui.cardview.CardViewContents
import com.danchoo.components.ui.cardview.CardViewContentsType
import com.danchoo.date.R

@Preview("light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun CardPreviewPreview() {
    MyApplicationTheme {
        CardView(modifier = Modifier) {
            CardViewContents(
                modifier = Modifier,
                type = CardViewContentsType.SmallImages,
                title = "Title",
                description = "description",
                images = listOf(
                    R.drawable.the_gleaners,
                    R.drawable.the_gleaners,
                    R.drawable.the_gleaners,
                    R.drawable.the_gleaners,
                    R.drawable.the_gleaners,
                    R.drawable.the_gleaners,
                    R.drawable.the_gleaners,
                    R.drawable.the_gleaners
                )
            )
        }
    }
}
