package com.example.trabalho_001.utils

import android.app.Activity
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.trabalho_001.R
import com.google.android.material.snackbar.Snackbar

fun AppCompatActivity.snackBar(view: View, @StringRes resId: Int) {
    hideKeyboard()

    setupSnackBar(view, resId).apply {
        this.show()
    }
}


fun AppCompatActivity.hideKeyboard() {
    val imm =
        window.context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(window.decorView.windowToken, 0)
}


private fun AppCompatActivity.setupSnackBar(
    v: View,
    @StringRes resId: Int
): Snackbar {
    return Snackbar.make(v, resId, Snackbar.LENGTH_LONG).apply {
        view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text).apply {
            gravity = Gravity.CENTER
            textAlignment = View.TEXT_ALIGNMENT_CENTER

        }
    }
}

fun FragmentActivity.replaceView(fragment: Fragment, @IdRes containerId: Int = R.id.container) {
    supportFragmentManager.beginTransaction()
        .replace(containerId, fragment)
        .commitNow()
}