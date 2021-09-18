package com.dika.quranapp.presenter.common

import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.showSnackBar(message: String?) {
    view?.let {
        message?.let { it1 ->
            Snackbar.make(
                it,
                it1,
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }
}