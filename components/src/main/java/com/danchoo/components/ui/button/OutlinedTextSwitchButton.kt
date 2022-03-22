package com.danchoo.components.ui.button

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.danchoo.components.extension.applyAlpha80
import com.danchoo.components.theme.MyApplicationTheme

@Composable
fun OutlinedTextSwitchButton(
    modifier: Modifier = Modifier,
    text: String,
    checked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit
) {
    OutlinedButton(
        modifier = modifier,
        onClick = {
            onCheckedChange(!checked)
        }
    ) {

        Text(
            modifier = Modifier.weight(1f),
            text = text,
            style = MyApplicationTheme.typography.subtitle1,
            color = MyApplicationTheme.colors.textPrimary.applyAlpha80()
        )

        Switch(
            modifier = Modifier.defaultMinSize(MyApplicationTheme.minSize),
            checked = checked,
            onCheckedChange = {
                onCheckedChange(!checked)
            }
        )
    }
}