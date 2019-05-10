package com.minic.kt.utils.ext

import com.minic.kt.base.App

/**
 * @ClassName: ViewExt
 * @Description:
 * @Author: ChenYy
 * @Date: 2019-05-10 17:01
 */

fun dp2px(dpValue: Float): Int {
    val scale = App.INSTANCE.resources.displayMetrics.density
    return (dpValue * scale + 0.5f).toInt()
}