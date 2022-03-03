package com.danchoo.date.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import com.danchoo.common.BaseActivity
import com.danchoo.components.theme.CustomTheme
import com.danchoo.components.theme.MyApplicationTheme
import com.danchoo.date.presentation.utils.glide.GlideAppImageLoaderImpl
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
        setContent {
            MyApplicationTheme(
                customTheme = CustomTheme.Indigo
            ) {
                CompositionLocalProvider(
                    LocalImageLoader provides GlideAppImageLoaderImpl()
                ) {
                    MainApp()
                }
            }
        }
    }

}