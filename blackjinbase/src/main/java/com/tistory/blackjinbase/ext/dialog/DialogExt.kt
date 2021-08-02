package com.tistory.blackjinbase.ext.dialog

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

fun <B : ViewDataBinding> Context.showCustomDialog(
    @LayoutRes layoutId: Int,
    initFun: (dialog: Dialog, B) -> Unit
) {
    val dialog = Dialog(this)
    val inflater = LayoutInflater.from(this)
    val binding: B = DataBindingUtil.inflate(inflater, layoutId, null, false)
    dialog.setContentView(binding.root)
    dialog.show()

    initFun.invoke(dialog, binding)
}