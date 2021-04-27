package com.tistory.blackjinbase.ui

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import com.tistory.blackjinbase.R
import com.tistory.blackjinbase.util.Dlog

class LoadingDialog(context: Context) : Dialog(context, R.style.dialog_transparent_full_screen) {

    init {
        setCancelable(false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading)
    }

    override fun show() {
        try {
            super.show()
        } catch (e: WindowManager.BadTokenException) {
            Dlog.e(e.message)
        } catch (e: Exception) {
            Dlog.e(e.message)
        }
    }

    override fun dismiss() {
        try {
            super.dismiss()
        } catch (e: IllegalArgumentException) {
            Dlog.e(e.message)
        }
    }
}