package com.danchoo.date.presentation.base

import androidx.activity.ComponentActivity

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