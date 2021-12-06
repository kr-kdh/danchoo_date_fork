package com.danchoo.date.presentation.ui.main.category

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import com.danchoo.common.BaseActivity
import com.danchoo.date.presentation.ui.components.main.editor.category.CategoriesEditorApp
import com.danchoo.date.presentation.ui.main.category.model.CATEGORY_ID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoriesEditorActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CategoriesEditorApp()
        }
    }

    companion object {
        fun startActivity(context: Context, categoryId: Long = 0L) {
            val intent = Intent(context, CategoriesEditorActivity::class.java)
            intent.putExtra(CATEGORY_ID, categoryId)
            context.startActivity(intent)
        }
    }
}