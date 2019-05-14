package com.minic.base.extens

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat

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
 * 初始化Toolbar
 */
fun AppCompatActivity.initToolbar(mToolbar: Toolbar, mTitle: String = "", isBack: Boolean = true) {
    this.apply {
        setSupportActionBar(mToolbar)
        supportActionBar!!.title = mTitle
        supportActionBar!!.setDisplayHomeAsUpEnabled(isBack)
        mToolbar.setNavigationOnClickListener { onBackPressed() }
    }
}

/**
 * 启动Activity
 * inline一般用于高阶函数作为参数
 */
inline fun <T> Context.comeOnStart(clazz: Class<T>, action: (intent: Intent) -> Unit) {
    val intent = Intent(this, clazz)
    action(intent)
    this.startActivity(intent)
}

/**
 * 打印日志--扩展函数
 */
fun Any.logD(tag: String = "GANK_LOG",
             msg: String? = "") {
    Log.d(tag, msg)
}
