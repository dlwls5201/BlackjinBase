package com.tistory.blackjin.ext

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.widget.Toast
import androidx.annotation.StringRes
import com.tistory.blackjin.ext.dialog.AlertBuilder
import com.tistory.blackjin.ext.dialog.AndroidAlertBuilder

inline fun <A, B, R> ifNotNull(a: A?, b: B?, code: (A, B) -> R) {
    if (a != null && b != null) {
        code(a, b)
    }
}

inline fun <A, B, C, R> ifNotNull(a: A?, b: B?, c: C?, code: (A, B, C) -> R) {
    if (a != null && b != null && c != null) {
        code(a, b, c)
    }
}

fun Context.toast(message: CharSequence?) {
    if (message.isNullOrEmpty()) return
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.toast(@StringRes messageId: Int) {
    Toast.makeText(this, messageId, Toast.LENGTH_SHORT).show()
}

fun Context.longToast(message: CharSequence?) {
    if (message.isNullOrEmpty()) return
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Context.longToast(@StringRes messageId: Int) {
    Toast.makeText(this, messageId, Toast.LENGTH_LONG).show()
}

fun Context.alert(
    title: CharSequence? = null,
    message: CharSequence? = null,
    init: (AlertBuilder<DialogInterface>.() -> Unit)? = null
): AlertBuilder<AlertDialog> {
    return AndroidAlertBuilder(this).apply {
        if (title != null) {
            this.title = title
        }
        if (message != null) {
            this.message = message
        }
        if (init != null) init()
    }
}

