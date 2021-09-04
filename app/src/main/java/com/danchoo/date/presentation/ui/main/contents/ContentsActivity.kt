package com.danchoo.date.presentation.ui.main.contents

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.core.view.WindowCompat
import com.danchoo.date.presentation.base.BaseActivity
import com.danchoo.date.presentation.ui.components.main.contents.ContentsApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContentsActivity : BaseActivity() {

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This app draws behind the system bars, so we want to handle fitting system windows
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ContentsApp()
        }
    }

    companion object {
        fun startContentsActivity(context: Context) {
            val intent = Intent(context, ContentsActivity::class.java)
            context.startActivity(intent)
        }
    }

}