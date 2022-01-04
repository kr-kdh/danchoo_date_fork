package com.danchoo.commonutils.permission

/**
 * 1. 퍼미션 리스트를 받는다
 * 2. rememberMultiplePermissionsState or rememberPermissionState 으로 퍼미션 상태를 받아온다.
 * 3. 퍼미션을 구분한다 (success / permissionNotGrantedContent / permissionNotGrantedContent doNotShowRationale / permissionNotAvailableContent)
 * 4. 승인하지 않은 퍼미션 관련 처리를 해준다.
 *  - 앱 강제 종료
 *  - 셋팅으로 보내기기
 */
//@SuppressLint("PermissionLaunchedDuringComposition")
//@OptIn(ExperimentalPermissionsApi::class)
//@Composable
//fun RequestPermission(
//    permissions: List<String>,
//    notGrantedContent: @Composable (permission: String, total: Int, current: Int) -> Unit,
//    notAvailableContent: @Composable (permission: String, total: Int, current: Int) -> Unit,
//    availableContent: @Composable (permission: String, total: Int, current: Int) -> Unit,
//    content: @Composable (available:List<String>, notAvailable:List<String>) -> Unit
//) {
//    val state = rememberMultiplePermissionsState(permissions)
//
//    if (state.allPermissionsGranted) {
//        content(permissions, emptyList())
//        return
//    }
//
//    val notGrantedList = state.permissions.filter {
//        it.shouldShowRationale || !it.permissionRequested
//    }
//
//    state.launchMultiplePermissionRequest()
////
////    var doNotShowRationale by rememberSaveable { mutableStateOf(false) }
////
////    val cameraPermissionState = rememberPermissionState(android.Manifest.permission.CAMERA)
////    cameraPermissionState.launchPermissionRequest()
////    PermissionRequired(
////        permissionState = cameraPermissionState,
////        permissionNotGrantedContent = {
////            if (doNotShowRationale.value) {
////                Text("Feature not available")
////            } else {
////                Rationale(
////                    onDoNotShowRationale = { doNotShowRationale.value = true },
////                    onRequestPermission = { cameraPermissionState.launchPermissionRequest() }
////                )
////            }
////                                      },
////        permissionNotAvailableContent = { /*TODO*/ }) {
////
////    }
////    val multiplePermissionsState = rememberMultiplePermissionsState(
////        permissions
//////        listOf(
//////            android.Manifest.permission.READ_EXTERNAL_STORAGE,
//////            android.Manifest.permission.CAMERA,
//////        )
////    )
//
//}
//
//@OptIn(ExperimentalPermissionsApi::class)
//@Composable
//fun CheckPermission(
//    multiplePermissionsState: MultiplePermissionsState,
//    navigateToSettingsScreen: () -> Unit
//) {
//    val doNotShowRationale = rememberSaveable { mutableStateOf(false) }
//
//    when {
//        multiplePermissionsState.allPermissionsGranted -> {
//        }
//        multiplePermissionsState.shouldShowRationale || !multiplePermissionsState.permissionRequested -> {
//            if (doNotShowRationale.value) {
//                // 다시 보지 않음. 설정함
//            } else {
//                // 확인
//                // 다시 보지 않기 button
//            }
//        }
//        else -> {
//            // 셋팅으로 보내야함.
//                multiplePermissionsState.revokedPermissions
//        }
//    }
//}
//
////@OptIn(ExperimentalPermissionsApi::class)
////private fun getPermissionsText(permissions: List<PermissionState>): String {
////    val revokedPermissionsSize = permissions.size
////    if (revokedPermissionsSize == 0) return ""
////
////    val textToShow = StringBuilder().apply {
////        append("The ")
////    }
////
////    for (i in permissions.indices) {
////        textToShow.append(permissions[i].permission)
////        when {
////            revokedPermissionsSize > 1 && i == revokedPermissionsSize - 2 -> {
////                textToShow.append(", and ")
////            }
////            i == revokedPermissionsSize - 1 -> {
////                textToShow.append(" ")
////            }
////            else -> {
////                textToShow.append(", ")
////            }
////        }
////    }
////    textToShow.append(if (revokedPermissionsSize == 1) "permission is" else "permissions are")
////    return textToShow.toString()
////}