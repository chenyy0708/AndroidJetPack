package com.cyy.base.extens

import android.R
import android.app.Activity
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
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
fun Fragment.showMsg(message: String) {
    make(
            this.view!!,
            message,
            Snackbar.LENGTH_SHORT,
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

