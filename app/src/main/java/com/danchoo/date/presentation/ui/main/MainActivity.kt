package com.danchoo.date.presentation.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.danchoo.common.BaseActivity
import com.danchoo.components.theme.CustomTheme
import com.danchoo.components.theme.MyApplicationTheme
import com.danchoo.date.presentation.ui.common.glide.GlideAppImageLoaderImpl
import com.danchoo.date.presentation.ui.components.MainApp
import com.danchoo.glideimage.LocalImageLoader
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity() {


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
                CompositionLocalProvider(LocalImageLoader provides GlideAppImageLoaderImpl()) {
                    MainApp()
                }
            }
        }
    }

}