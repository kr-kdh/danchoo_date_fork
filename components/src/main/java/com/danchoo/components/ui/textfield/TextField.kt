package com.danchoo.components.ui.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import com.danchoo.components.theme.MainTheme
import com.danchoo.components.ui.button.IconButton

@Composable
fun OutlinedTextField(
    modifier: Modifier = Modifier,
    textFieldValue: TextFieldValue,
    label: String? = null,
    placeholder: String? = label,
    onValueChange: (TextFieldValue) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = textFieldValue,
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
            if (textFieldValue.text.isNotEmpty()) {
                IconButton(imageVector = Icons.Filled.Cancel) {
                    onValueChange(
                        textFieldValue.copy("", TextRange.Zero, null)
                    )
                }
            }
        },
        onValueChange = { onValueChange(it) }
    )
}

@Composable
fun TitleTextField(
    modifier: Modifier = Modifier,
    textFieldValue: TextFieldValue,
    title: String,
    placeholder: String,
    onValueChange: (TextFieldValue) -> Unit
) {
    Column {
        Text(
            modifier = modifier.padding(
                top = MainTheme.spacing.baseLineSpacingMedium
            ),
            text = title
        )

        OutlinedTextField(
            modifier = modifier.padding(
                top = MainTheme.spacing.baseLineSpacingSmall
            ),
            textFieldValue = textFieldValue,
            label = placeholder,
        ) {
            onValueChange(it)
        }
    }
}