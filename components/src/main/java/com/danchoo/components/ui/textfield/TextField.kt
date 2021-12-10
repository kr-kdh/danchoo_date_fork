package com.danchoo.components.ui.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import com.danchoo.components.theme.MainTheme
import com.danchoo.components.ui.button.ClearButton
import com.danchoo.components.ui.text.Text
import com.danchoo.components.ui.text.TextType

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
                Text(type = TextType.Label, text = it)
            }

        },
        placeholder = {
            placeholder?.let {
                Text(type = TextType.PlaceHolder, text = it)
            }
        },
        singleLine = true,
        trailingIcon = {
            if (textFieldValue.text.isNotEmpty()) {
                ClearButton {
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
            type = TextType.Description1,
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