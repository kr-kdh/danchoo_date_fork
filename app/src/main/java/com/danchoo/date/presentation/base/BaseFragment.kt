package com.danchoo.date.presentation.base

import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<DataBinding : ViewBinding>(
) : Fragment() {

    protected lateinit var binding: DataBinding

    private var dialog: Dialog? = null

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

}