package com.danchoo.date.presentation.base

import android.app.Dialog
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseActivity : ComponentActivity() {

//    private var dialog: Dialog? = null
//    private val disposables = CompositeDisposable()
//
//    protected fun showErrorDialog(
//        str: String,
//        doneAction: (() -> Unit)? = null
//    ) {
//        if (dialog != null) {
//            return
//        }
//
//        dialog = AlertDialog.Builder(this)
//            .setMessage(str)
//            .setPositiveButton(android.R.string.ok) { dialog, _ ->
//                dialog.dismiss()
//                doneAction?.invoke()
//            }
//            .setOnDismissListener { dialog = null }
//            .create()
//
//        dialog?.show()
//    }
//
//    protected fun showErrorDialog(
//        res: Int,
//        doneAction: (() -> Unit)? = null
//    ) {
//        showErrorDialog(getString(res), doneAction)
//    }
//
//    fun addDisposable(disposable: Disposable) {
//        disposables.add(disposable)
//    }
//
//    override fun onDestroy() {
//        disposables.clear()
//        super.onDestroy()
//    }
//
//    override fun finish() {
//        disposables.clear()
//        super.finish()
//    }
}