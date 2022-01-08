package com.danchoo.components.permission

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.rememberPermissionState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


/**
 * 처음
 * hasPermission = false
 * shouldShowRationale = false
 * permissionRequested = false
 *
 * 1 번 거부
 * hasPermission = false
 * shouldShowRationale = true
 * permissionRequested = true
 *
 * 2 번 거부
 * hasPermission = false
 * shouldShowRationale = false
 * permissionRequested = true
 *
 * 2 번 거부 후 껐다 켰을때
 * hasPermission = false
 * shouldShowRationale = false
 * permissionRequested = false
 *
 * 2 번 거부 후 껐다 키고 permission 요청 -> 시스템 팝업 나오지 않음
 * hasPermission = false
 * shouldShowRationale = false
 * permissionRequested = true
 */

@Composable
fun RequestPermission(
    permission: String,
    onSuccess: () -> Unit = {},
    onDenied: () -> Unit = {},
    onRequestMoveSetting: () -> Unit = {},
    onRequestDismiss: () -> Unit = {}
) {
    val permissionState = rememberRequestPermissionState(
        state = rememberPermissionState(permission)
    )

    when {
        permissionState.state.hasPermission -> {
            onSuccess()
            onRequestDismiss()
        }
        !permissionState.state.permissionRequested -> {
            permissionState.showPermission()
        }
        permissionState.state.permissionRequested && permissionState.state.shouldShowRationale -> {
            // 한번 거부
            onDenied()
            onRequestDismiss()
        }
        permissionState.state.permissionRequested && !permissionState.state.shouldShowRationale -> {
            // 두번 거부
            onRequestMoveSetting()
            onRequestDismiss()
        }
    }
}

private class RequestPermissionState(
    val state: PermissionState,
    private val scope: CoroutineScope
) {
    fun showPermission() {
        scope.launch { state.launchPermissionRequest() }
    }
}

@Composable
private fun rememberRequestPermissionState(
    state: PermissionState,
    scope: CoroutineScope = rememberCoroutineScope(),

    ) = remember(state, scope) {
    RequestPermissionState(state, scope)
}