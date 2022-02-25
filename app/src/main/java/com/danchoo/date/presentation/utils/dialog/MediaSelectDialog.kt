package com.danchoo.date.presentation.utils.dialog

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.danchoo.components.ui.dialog.ListDialog
import com.danchoo.date.R


@Composable
fun MediaSelectDialog(
    onItemSelected: (MediaSelectType) -> Unit = { },
    onDismissRequest: () -> Unit = {}
) {
    ListDialog(
        items = MediaSelectType.values().map { stringResource(id = it.res) },
        onItemSelected = { index: Int, _: String ->
            val selected = when (index) {
                MediaSelectType.Camera.ordinal -> MediaSelectType.Camera
                MediaSelectType.Gallery.ordinal -> MediaSelectType.Gallery
                else -> return@ListDialog
            }

            onItemSelected(selected)
            onDismissRequest()
        },
        onDismissRequest = onDismissRequest
    )
}

enum class MediaSelectType(@StringRes val res: Int) {
    Camera(R.string.camera),
    Gallery(R.string.gallery)
}