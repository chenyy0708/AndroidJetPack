package com.cyy.base.extens

import android.app.Activity
import android.content.Intent
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.v4.content.ContextCompat
import android.util.Log
import com.cyy.base.BuildConfig

/**
 * @author       :ChenYangYi
 * @date         :2018/09/29/15:18
 * @description  :Activity 扩展函数
 * @github       :https://github.com/chenyy0708
 */

/**
 * 获取颜色值--扩展函数
 */
fun Activity.getCompactColor(@ColorRes colorRes: Int): Int = ContextCompat.getColor(this, colorRes)

/**
 * dp转px--扩展函数
 */
fun Activity.dpToPx(@DimenRes resID: Int): Int = this.resources.getDimensionPixelOffset(resID)

/**
 * 跳转页面--扩展函数
 */
fun Activity.navigateToActivity(c: Class<*>) {
    val intent = Intent()
    intent.setClass(this, c)
    startActivity(intent)
}

/**
 * 打印日志--扩展函数
 */
fun Any.logD(msg: String?) {
    if (BuildConfig.DEBUG) {
        Log.d(javaClass.simpleName, msg)
    }
}