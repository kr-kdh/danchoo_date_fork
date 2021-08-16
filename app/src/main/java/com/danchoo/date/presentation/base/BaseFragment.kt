package com.danchoo.date.presentation.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseFragment<DataBinding : ViewBinding>(
) : Fragment() {

    protected lateinit var binding: DataBinding

    private var dialog: Dialog? = null
    private val disposables = CompositeDisposable()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.setVariable(bindingVariable, viewModel)
    }

    protected fun showErrorDialog(
        str: String,
        doneAction: (() -> Unit)? = null
    ) {
        if (dialog != null) {
            return
        }

        context?.let {
            dialog = AlertDialog.Builder(it)
                .setMessage(str)
                .setPositiveButton(android.R.string.ok) { dialog, _ ->
                    dialog.dismiss()
                    doneAction?.invoke()
                }
                .setOnDismissListener { dialog = null }
                .create()
            dialog?.show()
        }
    }

    protected fun showErrorDialog(
        res: Int,
        doneAction: (() -> Unit)? = null
    ) {
        showErrorDialog(getString(res), doneAction)
    }

    fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    override fun onPause() {
        disposables.clear()
        super.onPause()
    }

    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }

    override fun onDetach() {
        disposables.clear()
        super.onDetach()
    }
}