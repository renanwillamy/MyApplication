package com.sample.twitterapplication.utils

import android.app.AlertDialog
import android.content.Context

object FeedBackUtils {
    fun showDialog(context: Context, title: String, msg: String) {
        val alertDialogBuilder = AlertDialog.Builder(context)
        alertDialogBuilder.setCancelable(false)
        alertDialogBuilder.setTitle(title)
        alertDialogBuilder.setMessage(msg)
        alertDialogBuilder.setNeutralButton(context.getString(android.R.string.ok), null)
        alertDialogBuilder.show()
    }
}