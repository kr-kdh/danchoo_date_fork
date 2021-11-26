package com.danchoo.date.presentation.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.danchoo.components.theme.CustomTheme
import com.danchoo.components.theme.MyApplicationTheme
import com.danchoo.date.presentation.base.BaseActivity
import com.danchoo.date.presentation.ui.components.MainApp
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity() {


    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This app draws behind the system bars, so we want to handle fitting system windows
//        WindowCompat.setDecorFitsSystemWindows(window, false)
//        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true){
//            override fun handleOnBackPressed() {
//                Log.d("_SMY", "handleOnBackPressed")
//            }
//
//        })
        var isDarkMode by mutableStateOf(false)
        setContent {
            MyApplicationTheme(
                customTheme = CustomTheme.Indigo
            ) {
                MainApp()
            }
        }
    }

}