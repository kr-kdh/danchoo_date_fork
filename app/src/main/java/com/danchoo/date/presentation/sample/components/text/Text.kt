package com.danchoo.date.presentation.sample.components.text

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
import com.danchoo.components.ui.text.Text
import com.danchoo.components.ui.text.TextType

@Preview("light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun TextPreview() {
    MyApplicationTheme {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                type = TextType.Title1,
                text = "TextType.Title1"
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                type = TextType.Title1Bold,
                text = "TextType.Title1Bold"
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                type = TextType.Title2,
                text = "TextType.Title2"
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                type = TextType.Title2Bold,
                text = "TextType.Title2Bold"
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                type = TextType.Description1,
                text = "TextType.Description1"
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                type = TextType.Description2,
                text = "TextType.Description2"
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                type = TextType.Label,
                text = "TextType.Label"
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                type = TextType.PlaceHolder,
                text = "TextType.PlaceHolder"
            )

            Spacer(modifier = Modifier.height(10.dp))

        }
    }
}