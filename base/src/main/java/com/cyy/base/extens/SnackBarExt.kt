package com.cyy.base.extens

import android.app.Activity
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import io.github.tonnyl.light.success
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
    success(this.window.decorView, message, Snackbar.LENGTH_SHORT)
            .show()
}

/**
 * 提示消息
 */
fun Fragment.showMsg(message: String) {
    success(this.view!!, message, Snackbar.LENGTH_SHORT)
            .show()
}

/**
 * 警告
 */
fun Activity.showWarning(message: String) {
    warning(this.window.decorView, "message", Snackbar.LENGTH_SHORT).show()
}

