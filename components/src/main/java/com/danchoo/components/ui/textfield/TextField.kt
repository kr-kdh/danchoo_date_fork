package com.danchoo.components.ui.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.danchoo.components.theme.MyApplicationTheme
import com.danchoo.components.ui.button.IconButton

@Composable
fun OutlinedTextField(
    modifier: Modifier = Modifier,
    value: String,
    label: String? = null,
    placeholder: String? = label,
    onValueChange: (String) -> Unit = {}
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        label = {
            label?.let {
                Text(text = it)
            }
        },
        placeholder = {
            placeholder?.let {
                Text(text = it)
            }
        },
        singleLine = true,
        trailingIcon = {
            if (value.isNotEmpty()) {
                IconButton(imageVector = Icons.Filled.Cancel) {
                    onValueChange("")
                }
            }
        },
        onValueChange = { onValueChange(it) }
    )
}

@Composable
fun TitleTextField(
    modifier: Modifier = Modifier,
    value: String,
    title: String,
    placeholder: String,
    onValueChange: (String) -> Unit = {}
) {
    Column {
        Text(
            modifier = modifier.padding(
                top = MyApplicationTheme.spacing.baseLineSpacingMedium
            ),
            text = title
        )

        OutlinedTextField(
            modifier = modifier.padding(
                top = MyApplicationTheme.spacing.baseLineSpacingSmall
            ),
            value = value,
            label = placeholder,
        ) {
            onValueChange(it)
        }
    }
}