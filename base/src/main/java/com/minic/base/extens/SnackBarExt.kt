package com.minic.base.extens

import android.R
import android.app.Activity
import com.google.android.material.snackbar.Snackbar
import androidx.core.content.ContextCompat
import io.github.tonnyl.light.make
import io.github.tonnyl.light.warning

/**
 * @author       :ChenYangYi
 * @date         :2018/09/30/09:56
 * @description  :SnackBar扩展函数
 * @github       :https://github.com/chenyy0708
 */

/**
 * 提示消息
 */
fun Activity.showMsg(message: String) {
    make(
            this.window.decorView,
            message,
            Snackbar.LENGTH_SHORT,
            null,
            ContextCompat.getColor(this, io.github.tonnyl.light.R.color.color_normal),
            ContextCompat.getColor(this, R.color.white)).show()
}

/**
 * 提示消息
 */
fun androidx.fragment.app.Fragment.showMsg(message: String) {
    make(
            this.view!!,
            message,
            com.google.android.material.snackbar.Snackbar.LENGTH_SHORT,
            null,
            ContextCompat.getColor(view!!.context, io.github.tonnyl.light.R.color.color_normal),
            ContextCompat.getColor(view!!.context, R.color.white)).show()
}

/**
 * 警告
 */
fun Activity.showWarning(message: String) {
    warning(this.window.decorView, "message", Snackbar.LENGTH_SHORT).show()
}

