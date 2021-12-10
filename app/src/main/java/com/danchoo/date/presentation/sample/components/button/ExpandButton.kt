package com.danchoo.date.presentation.sample.components.button

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danchoo.components.theme.MyApplicationTheme
import com.danchoo.components.ui.button.ExpandButton

@Preview("light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ExpandButtonPreview() {
    MyApplicationTheme {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ExpandButton(
                expanded = false,
                enable = true
            ) {}

            Spacer(modifier = Modifier.height(10.dp))

            ExpandButton(
                expanded = false,
                enable = false
            ) {}

            Spacer(modifier = Modifier.height(10.dp))

            ExpandButton(
                expanded = true,
                enable = true
            ) {}

            Spacer(modifier = Modifier.height(10.dp))

            ExpandButton(
                expanded = true,
                enable = false
            ) {}
        }
    }
}